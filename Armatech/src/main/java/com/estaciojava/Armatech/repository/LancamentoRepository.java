package com.estaciojava.Armatech.repository;

import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, String> {
    // Metodo para deletar todos os lançamentos associados a um produto
    void deleteByProduto(Produto produto);
}