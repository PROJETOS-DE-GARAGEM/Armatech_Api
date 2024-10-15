package com.estaciojava.Armatech.model;


import javax.persistence.*;

@entity //Indica que essa classe é uma entidade JPA, que será mapeada para uma tabela no BD.
@table(name = "usuarios")// Define o nome da tabela no banco de dados.

public class Usuario {
    //Indicam que o campo id será a chave primária gerada automaticamente.
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String email;
    private String senha;


    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }











}
