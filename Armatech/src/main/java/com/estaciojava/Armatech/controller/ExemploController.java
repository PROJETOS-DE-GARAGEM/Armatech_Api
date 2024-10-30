package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.filter.ExemploFilter;
import com.estaciojava.Armatech.model.Exemplo;
import com.estaciojava.Armatech.service.ExemploService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplo")
public class ExemploController extends CrudController<Exemplo,Exemplo, ExemploFilter, Long> {

    public ExemploController(ExemploService service) {
        super(service);
    }


}
