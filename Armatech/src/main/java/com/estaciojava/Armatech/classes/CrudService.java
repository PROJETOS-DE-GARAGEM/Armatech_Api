package com.estaciojava.Armatech.classes;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    T save(T entity); // Método para salvar a entidade

    List<T> findAll(); // Método para buscar todas as entidades

    Optional<T> findById(ID id); // Método para buscar uma entidade pelo ID

    T update(ID id, T entity); // Método para atualizar uma entidade

    void delete(ID id); // Método para deletar uma entidade pelo ID
}
