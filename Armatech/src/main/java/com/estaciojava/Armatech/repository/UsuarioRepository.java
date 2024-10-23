package com.estaciojava.Armatech.repository;
import com.estaciojava.Armatech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);
}
