package com.estaciojava.Armatech.classes;

import java.util.List;
import java.util.Optional;
//T tipo do model
//DTO tipo de DTO
//F tipo de Fitro
//ID tipo do id
public interface CrudService<T, DTO ,F, ID> {

    T save(T entity); // Método para salvar a entidade

    List<DTO> findAll(F filter); // Método para buscar todas as entidades

    Optional<DTO> findById(ID id); // Método para buscar uma entidade pelo ID

    T update(ID id, T entity); // Método para atualizar uma entidade

    void delete(ID id); // Método para deletar uma entidade pelo ID
}
