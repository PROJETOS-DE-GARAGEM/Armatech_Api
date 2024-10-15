package com.estaciojava.Armatech.repository;

import com.estaciojava.Armatech.model.Usuario;
import org.springframework.data.jpa.repository.jpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
