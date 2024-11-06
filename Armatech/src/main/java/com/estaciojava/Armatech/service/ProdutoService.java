package com.estaciojava.Armatech.service;

import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.repository.LancamentoRepository;
import com.estaciojava.Armatech.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class ProdutoService extends CrudServiceImpl<Produto , Produto , Produto, String> {

    private final LancamentoRepository lancamentoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, LancamentoRepository lancamentoRepository) {
        super(produtoRepository);
        this.lancamentoRepository =lancamentoRepository;
    }

    //Sobrescrevendo o metodo da super-classe CrudService.
    @Override
    public Lancamento saveAfter(Produto produto) {

        //Intânciando lançamento para receber os dados do registro ao cadastrar um produto
        Lancamento lancamento = new Lancamento();

        //Instânciando LocalDateTime para receber a data do registro do produto
        Timestamp dataEntrada = new Timestamp(System.currentTimeMillis());
//
//        //Formatação da String de data
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime dataFormatada = LocalDateTime.parse("dd-MM-yyyy", formatter);

        //Recebendo os dados do produto cadastrado e passando para Repository de Lançamento.
        lancamento.setQuantidade(produto.getQuantidade());
        lancamento.setProduto(produto);
        Lancamento.TipoLancamento tipoLancamento = Lancamento.TipoLancamento.ENTRADA;

        lancamento.setTipo(tipoLancamento);
        lancamento.setDataEntrada(dataEntrada);

        lancamentoRepository.save(lancamento);

        return lancamento;
    }
}