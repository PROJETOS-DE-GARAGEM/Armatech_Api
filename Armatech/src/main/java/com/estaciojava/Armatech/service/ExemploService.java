package com.estaciojava.Armatech.service;

import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.filter.ExemploFilter;
import com.estaciojava.Armatech.model.Exemplo;
import com.estaciojava.Armatech.repository.ExemploRepository;
import com.estaciojava.Armatech.specification.ExemploSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.List;

@Service
public class ExemploService extends CrudServiceImpl<Exemplo,Exemplo, ExemploFilter, Long> {


    private final JpaSpecificationExecutor<Exemplo> repositorySpecification;
    private final ExemploSpecification specificationClass;
    public ExemploService(
            ExemploRepository repository,
            JpaSpecificationExecutor<Exemplo> specificRepository,
            ExemploSpecification specification) {
        super(repository);
        this.repositorySpecification = specificRepository;
        this.specificationClass = specification;
    }

    @Override
    public Exemplo save(Exemplo entity) {
        System.out.println(entity.getId());
        System.out.println( entity.getNome());
        return super.save(entity);
    }

    @Override
    public List<Exemplo> findAll(ExemploFilter filter) {
        try {
            List<Exemplo> entities;
            if(ObjectUtils.isEmpty(filter)){
                entities = (List<Exemplo>) repository.findAll();
            }else {
                Specification<Exemplo> specification = specificationClass.filtrarPorCampos(filter);
                entities =  repositorySpecification.findAll(specification);
            }
            return this.findAllFormat(entities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
