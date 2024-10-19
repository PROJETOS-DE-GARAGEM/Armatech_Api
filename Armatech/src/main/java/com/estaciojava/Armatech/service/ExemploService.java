package com.estaciojava.Armatech.service;

import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Exemplo;
import com.estaciojava.Armatech.repository.ExemploRepository;
import org.springframework.stereotype.Service;

@Service
public class ExemploService extends CrudServiceImpl<Exemplo, Long> {

    public ExemploService(ExemploRepository repository) {
        super(repository);
    }
}
