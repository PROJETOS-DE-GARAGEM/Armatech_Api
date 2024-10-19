package com.estaciojava.Armatech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Exemplo {


    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) //conferir uma maneira de poder utilizar isso
    private Integer id;

    private String nome;

    // getters e setters

}
