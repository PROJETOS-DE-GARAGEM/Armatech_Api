package com.estaciojava.Armatech.repository;
import com.estaciojava.Armatech.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
