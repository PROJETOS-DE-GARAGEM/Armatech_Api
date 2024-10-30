package com.estaciojava.Armatech.specification;


import com.estaciojava.Armatech.filter.ExemploFilter;
import com.estaciojava.Armatech.model.Exemplo;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class ExemploSpecification {

    public  Specification<Exemplo> filtrarPorCampos(ExemploFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getNome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

