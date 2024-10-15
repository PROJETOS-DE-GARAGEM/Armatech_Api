package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends CrudController<Usuario, Long> {

    public UsuarioController(UsuarioService service) {
        super(service);
    }
}
