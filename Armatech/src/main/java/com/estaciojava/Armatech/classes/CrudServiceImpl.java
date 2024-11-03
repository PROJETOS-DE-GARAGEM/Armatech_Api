package com.estaciojava.Armatech.classes;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.lang.reflect.Field;

public abstract class CrudServiceImpl<T, DTO, F, ID> implements CrudService<T, DTO, F, ID> {

    public final CrudRepository<T, ID> repository;

    protected CrudServiceImpl(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }


    public T saveBefore(T entity) {
        return entity;
    }

    public void saveValidate(T entity) {
    }

    public void saveAfter(T entity) {
    }

    @Override
    public T save(T entity) {
        try {
            this.saveValidate(entity);
            entity = this.saveBefore(entity);
            repository.save(entity);
            this.saveAfter(entity);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DTO> findAllFormat(List<T> entities) {
        List<DTO> formatedEntities = (List<DTO>) entities;
        return formatedEntities;
    }


    @Override
    public List<DTO> findAll(F filter) {
        try {

            List<T> entities = (List<T>) repository.findAll();

            return this.findAllFormat(entities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    Optional<DTO> findByIdFormat(Optional<T> entity) {
        Optional<DTO> newEntity = (Optional<DTO>) entity;
        return newEntity;
    }

    @Override
    public Optional<DTO> findById(ID id) {
        try {
            Optional<T> entity = repository.findById(id);
            return this.findByIdFormat(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T updateBefore(T entity) {
        return entity;
    }

    public void updateValidate(T entity) {
        return;
    }

    public void updateAfter(T entity) {
        return;
    }

    @Override
    public T update(ID id, T entity) {
        try {
            // Busca a entidade existente no banco de dados usando o id
            T existingEntity = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));

            // Valida a entidade antes da atualização
            this.updateValidate(entity);

            // Atualiza os campos necessários na existingEntity com os valores de entity
            for (Field field : entity.getClass().getDeclaredFields()) {
                field.setAccessible(true); // Permite acesso a campos privados
                Object newValue = field.get(entity); // Obtém o valor do campo da nova entidade
                if (newValue != null) {
                    field.set(existingEntity, newValue); // Define o valor na entidade existente
                }
            }

            // Executa operações antes da atualização, se necessário
            existingEntity = this.updateBefore(existingEntity);

            // Salva a entidade existente atualizada
            T updatedEntity = repository.save(existingEntity);

            // Executa operações após a atualização, se necessário
            this.updateAfter(updatedEntity);

            return updatedEntity;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a entidade", e);
        }
    }
//    @Override
//    public T update(ID id, T entity) {
//        try {
//            if (repository.existsById(id)) {
//                this.updateValidate(entity);
//                entity = this.updateBefore(entity);
//
//                repository.save(entity);
//                this.updateAfter(entity);
//                return entity;
//            } else {
//                throw new RuntimeException("Entidade não encontrada");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void deleteBefore(ID id) {
        return;
    }

    public void deleteValidate(ID id) {
        return;
    }

    public void deleteAfter(ID id) {
        return;
    }

    @Override
    public void delete(ID id) {
        try {
            this.deleteValidate(id);
            this.deleteBefore(id);
            repository.deleteById(id);
            this.deleteAfter(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
