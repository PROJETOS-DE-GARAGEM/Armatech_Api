package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.model.Exemplo;
import com.estaciojava.Armatech.service.ExemploService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class ExemploController extends CrudController<Exemplo, Long> {

    public ExemploController(ExemploService service) {
        super(service);
    }
}
