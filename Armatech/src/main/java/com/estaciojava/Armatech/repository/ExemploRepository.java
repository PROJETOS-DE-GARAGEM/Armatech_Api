package com.estaciojava.Armatech.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.estaciojava.Armatech.model.Exemplo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExemploRepository extends  JpaRepository<Exemplo, Long>,  JpaSpecificationExecutor<Exemplo> {

}


