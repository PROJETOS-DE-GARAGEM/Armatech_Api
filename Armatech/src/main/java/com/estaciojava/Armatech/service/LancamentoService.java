package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.filter.ExemploFilter;
import com.estaciojava.Armatech.filter.LancamentoFilter;
import com.estaciojava.Armatech.model.Exemplo;
import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.repository.LancamentoRepository;
import com.estaciojava.Armatech.repository.ProdutoRepository;
import com.estaciojava.Armatech.specification.LancamentoSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService extends CrudServiceImpl<Lancamento, Lancamento, LancamentoFilter, String> {

    private final ProdutoRepository produtoRepository;
    private final JpaSpecificationExecutor<Lancamento> repositorySpecification;
    private final LancamentoSpecification specificationClass;
    public LancamentoService(
            LancamentoRepository lancamentoRepository,
            ProdutoRepository produtoRepository,
            JpaSpecificationExecutor<Lancamento> specificRepository,
            LancamentoSpecification specification
            ) {
        super(lancamentoRepository);
        this.produtoRepository = produtoRepository;
        this.repositorySpecification = specificRepository;
        this.specificationClass = specification;

    }

    @Override
    public List<Lancamento> findAll(LancamentoFilter filter) {
        try {
            List<Lancamento> entities;
            if(ObjectUtils.isEmpty(filter)){
                entities = (List<Lancamento>) repository.findAll();
            }else {
                Specification<Lancamento> specification = specificationClass.filtrarPorCampos(filter);
                entities =  repositorySpecification.findAll(specification);
            }
            return this.findAllFormat(entities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lancamento save(Lancamento entity) {
        return super.save(entity);
    }

    @Override
    public Lancamento saveAfter(Lancamento entity) {
        // buscar o produto com idproduto


        Optional<Produto> produtoOpicional = produtoRepository.findById(entity.getProduto().getId());
        Produto produto = produtoOpicional.get();

        if (ObjectUtils.isEmpty(produto)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        // verificar o tipo do lancamento

        if (entity.getTipo() == Lancamento.TipoLancamento.ENTRADA) {
            produto.setQuantidade(produto.getQuantidade() + entity.getQuantidade());
        } else if (entity.getTipo() == Lancamento.TipoLancamento.SAIDA) {
            if (produto.getQuantidade() < entity.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para realizar a saída.");
            }
            produto.setQuantidade(produto.getQuantidade() - entity.getQuantidade());
        }

        // Salva o produto atualizado no repositório
        produtoRepository.save(produto);

        return entity;
    }
}