package com.estaciojava.Armatech.classes;

import com.estaciojava.Armatech.filter.ExemploFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class CrudController<T,DTO ,F, ID> {

    protected final CrudService<T, DTO ,F,  ID> service;

    protected CrudController(CrudService<T,DTO ,F,ID> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<T> cadastrar(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<DTO>> buscarTodos(@ModelAttribute F filter ) {
        System.out.println(filter );

        return ResponseEntity.ok(service.findAll(filter));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTO> buscarUm(@PathVariable ID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> atualizar(@PathVariable ID id, @RequestBody T entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable ID id) {
    try {
        service.delete(id);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}
