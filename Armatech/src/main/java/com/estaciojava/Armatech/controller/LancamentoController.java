package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.service.LancamentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController extends CrudController<Lancamento, Long> {

    public LancamentoController(LancamentoService service) {
        super(service);
    }
}
