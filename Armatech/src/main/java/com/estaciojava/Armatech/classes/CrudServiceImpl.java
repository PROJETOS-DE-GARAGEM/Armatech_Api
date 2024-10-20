package com.estaciojava.Armatech.classes;

import com.estaciojava.Armatech.repository.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected final CrudRepository<T, ID> repository;

    protected CrudServiceImpl(CrudRepository repository) {
        this.repository = (CrudRepository<T, ID>) repository;
    }

    public  T saveBefore(T entity){
        return entity;
    }
    public  void saveValidate(T entity){
        return ;
    }
    public  void saveAfter(T entity){
        return ;
    }

    @Override
    public T save(T entity) {
try{
    this.saveValidate(entity);
    entity = this.saveBefore(entity);
    repository.save(entity);
    this.saveAfter(entity);
    return  entity;
} catch (Exception e) {
    throw new RuntimeException(e);
}
    }
    public List<T> findAllFormat(List<T> entities) {
        return entities;
    }


    @Override
    public List<T> findAll() {
     try{
         List<T> entities = (List<T>) repository.findAll();
         entities = this.findAllFormat(entities);

         return entities;
     } catch (Exception e) {
         throw new RuntimeException(e);
     }
    }

    Optional<T>  findByIdFormat(Optional<T> entity){
        return  entity;
    }
    @Override
    public Optional<T> findById(ID id) {
      try{
          Optional<T> entity = repository.findById(id);
          return this.findByIdFormat(entity);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }

    public  T updateBefore(T entity){
        return entity;
    }
    public  void updateValidate(T entity){
        return ;
    }
    public  void updateAfter(T entity){
        return ;
    }
    @Override
    public T update(ID id, T entity) {
try{
    if (repository.existsById(id)) {
        this.updateValidate(entity);
        entity = this.updateBefore(entity);

        repository.save(entity);
        this.updateAfter(entity);
        return entity;
    } else {
        throw new RuntimeException("Entidade não encontrada");
    }
} catch (Exception e) {
    throw new RuntimeException(e);
}
    }

    public  void deleteBefore(ID id){
        return ;
    }
    public  void deleteValidate(ID id){
        return ;
    }
    public  void deleteAfter(ID id){
        return ;
    }

    @Override
    public void delete(ID id) {
try{
    this.deleteValidate(id);
    this.deleteBefore(id);
    repository.deleteById(id);
    this.deleteAfter(id);
} catch (Exception e) {
    throw new RuntimeException(e);
}
    }
}
