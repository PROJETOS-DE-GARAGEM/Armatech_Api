package com.estaciojava.Armatech.specification;


import com.estaciojava.Armatech.filter.LancamentoFilter;
import com.estaciojava.Armatech.model.Lancamento;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


public class LancamentoSpecification {

    public Specification<Lancamento> filtrarPorCampos(LancamentoFilter filter) {
        return (root, query, cb) -> {
        if(filter.getDataComeco() !=null && filter.getDataFim() !=null){

            System.out.println(filter.getDataComeco()+ " essa e data comeco");
            System.out.println(filter.getDataFim() + " essa e data fim");

            Predicate condicaoDataEntrada = cb.and(
                    cb.isNotNull(root.get("dataEntrada")),
                    cb.between(root.get("dataEntrada"), filter.getDataComeco(), filter.getDataFim())
            );

            Predicate condicaoDataSaida = cb.and(
                    cb.isNotNull(root.get("dataSaida")),
                    cb.between(root.get("dataSaida"), filter.getDataComeco(), filter.getDataFim())
            );
            return cb.or(condicaoDataEntrada, condicaoDataSaida);
        }else {
            return cb.isNotNull(root.get("id"));
        }
        };
    }
}

