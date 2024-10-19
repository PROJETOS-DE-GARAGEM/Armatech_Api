package com.estaciojava.Armatech.repository;


import com.estaciojava.Armatech.model.Exemplo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ExemploRepository extends JpaRepository<Exemplo, Long> {
}


