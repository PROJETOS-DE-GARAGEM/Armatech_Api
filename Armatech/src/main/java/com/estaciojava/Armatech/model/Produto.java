package com.estaciojava.Armatech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String descricao;
    private Float preco;
    private Integer tipo;
    private Integer quantidade;
}

//@Entity indica que a classe "Produto" é mapeada como uma entidade para que o JPA faça a associação a uma tabela do BD.

//Indicam que o campo id será a chave primária gerada automaticamente.
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)

//Getters e Setters

//          Getter
//       Public Long getId(){
//         return id;
//       }

//          Setter
//       Public void seId(Long Id){
//         this.id = id;
//       }

//          Getter
//       Public Long getNome(){
//         return nome;
//       }

//          Setter
//       Public void seNome(String nome){
//         this.nome = nome;
//       }

//          Getter
//       Public Long getDescricao(){
//         return descricao;
//       }

//          Setter
//       Public void seDescricao(String descricao){
//         this.descricao = descricao;
//       }

//          Getter
//       Public Long getPreco(){
//         return preco;
//       }

//          Setter
//       Public void sePreco(Flot preco){
//         this.preco = preco;
//       }

//          Getter
//       Public Long getTipo(){
//         return tipo;
//       }

//          Setter
//       Public void seTipo(Interger tipo){
//         this.tipo = tipo;
//       }

//          Getter
//       Public Long getQuantidade(){
//         return quantidade;
//       }

//          Setter
//       Public void setQuantidade(Interger quantidade){
//         this.quantidade = quantidade;
//       }