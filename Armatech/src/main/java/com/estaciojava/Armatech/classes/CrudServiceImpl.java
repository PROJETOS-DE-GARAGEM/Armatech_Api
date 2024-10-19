package com.estaciojava.Armatech.classes;

import com.estaciojava.Armatech.repository.UsuarioRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected final CrudRepository<T, ID> repository;

    protected CrudServiceImpl(CrudRepository repository) {
        this.repository = (CrudRepository<T, ID>) repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T update(ID id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entidade não encontrada");
        }
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
