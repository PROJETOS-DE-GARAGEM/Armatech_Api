package com.estaciojava.Armatech.repository;

import com.estaciojava.Armatech.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
