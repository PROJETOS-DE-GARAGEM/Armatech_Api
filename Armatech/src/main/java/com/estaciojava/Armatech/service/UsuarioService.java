package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
