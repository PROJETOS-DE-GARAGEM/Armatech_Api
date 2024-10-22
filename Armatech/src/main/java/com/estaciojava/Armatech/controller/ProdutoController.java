package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends CrudController<Produto, Long> {

    public ProdutoController(ProdutoService service) { super(service); }
}
