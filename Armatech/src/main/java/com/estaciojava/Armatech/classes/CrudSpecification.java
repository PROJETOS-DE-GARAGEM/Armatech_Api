package com.estaciojava.Armatech.classes;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CrudSpecification<T ,F> {
    public  Specification<T> filtrarPorCampos(F filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        }
}
