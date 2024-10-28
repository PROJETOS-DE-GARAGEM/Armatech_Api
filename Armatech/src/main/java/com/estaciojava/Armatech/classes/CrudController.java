package com.estaciojava.Armatech.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Biblioteca com de array de lista
import java.util.Optional;
//Biblioteca de validar se é vazio ou não

public abstract class  CrudController<T, ID> {

    protected final CrudService<T, ID> service;

    // Injeção de dependências via construtor
    public CrudController(CrudService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public String create(@RequestBody T entity) {
        T savedEntity = service.save(entity);
        return "Item Cadastrado com Sucesso";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable ID id, @RequestBody T entity) {
        Optional<T> updatedEntity = service.update(id, entity);
        return "Atualizado com sucesso";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ID id) {
        boolean deleted = service.delete(id);
        return "Deletado";
    }

}
