package com.estaciojava.Armatech.repository;

import com.estaciojava.Armatech.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LancamentoRepository extends JpaRepository<Lancamento, String>, JpaSpecificationExecutor<Lancamento> {
}