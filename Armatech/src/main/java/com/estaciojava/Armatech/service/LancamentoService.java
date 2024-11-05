package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.repository.LancamentoRepository;
import com.estaciojava.Armatech.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService extends CrudServiceImpl<Lancamento , Lancamento , Lancamento, String> {

    private final ProdutoRepository produtoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository, ProdutoRepository produtoRepository) {
        super(lancamentoRepository);
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Lancamento save(Lancamento entity) {
        return super.save(entity);
    }

    @Override
    public Lancamento saveAfter(Lancamento entity) {
        // buscar o produto com idproduto
        Produto produto = entity.getProduto();

        if (produto.isEmpty) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        // verificar o tipo do lancamento

        if(entity.getTipo() == Lancamento.TipoLancamento.ENTRADA) {
            produto(produto + entity.getQuantidade());
        }else if(entity.getTipo() == Lancamento.TipoLancamento.SAIDA) {
            if (produto.getQuantidade() < entity.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para realizar a saída.");
            }
            produto(produto - entity.getQuantidade());
        }

        // Salva o produto atualizado no repositório
        produtoRepository.save(produto);

        return super.save(entity);
    }
}