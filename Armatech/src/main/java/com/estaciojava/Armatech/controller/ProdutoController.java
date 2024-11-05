package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends CrudController<Produto, Produto ,Produto, String> {

    public ProdutoController(ProdutoService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Produto> cadastrar(Produto entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable String id) {
        Optional<Produto> produto = service.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

