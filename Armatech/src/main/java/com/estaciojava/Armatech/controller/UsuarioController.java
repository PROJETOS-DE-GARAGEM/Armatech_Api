package com.estaciojava.Armatech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public  String listar(){
        return "deu certo";
    }
    @GetMapping("/{id}")
    public  String buscarUm(@PathVariable Integer id){

        return "usuario encontrado" + id;
    }

}
