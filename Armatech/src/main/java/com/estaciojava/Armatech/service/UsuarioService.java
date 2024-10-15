package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends CrudServiceImpl<Usuario, Long> {

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }
}
