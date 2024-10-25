package com.estaciojava.Armatech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer tipo;
    private Integer quantidade;
}

//@Entity indica que a classe "Produto" é mapeada como uma entidade para que o JPA faça a associação a uma tabela do BD.

//Indicam que o campo id será a chave primária gerada automaticamente.
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)

//Getters e Setters

//          Getter
//       Public String getId(){
//         return id;
//       }

//          Setter
//       Public void setId(String Id){
//         this.id = id;
//       }

//          Getter
//       Public String getNome(){
//         return nome;
//       }

//          Setter
//       Public void setNome(String nome){
//         this.nome = nome;
//       }

//          Getter
//       Public String getDescricao(){
//         return descricao;
//       }

//          Setter
//       Public void setDescricao(String descricao){
//         this.descricao = descricao;
//       }

//          Getter
//       Public Double getPreco(){
//         return preco;
//       }

//          Setter
//       Public void setPreco(Flot preco){
//         this.preco = preco;
//       }

//          Getter
//       Public Integer getTipo(){
//         return tipo;
//       }

//          Setter
//       Public void setTipo(Interger tipo){
//         this.tipo = tipo;
//       }

//          Getter
//       Public Interger getQuantidade(){
//         return quantidade;
//       }

//          Setter
//       Public void setQuantidade(Interger quantidade){
//         this.quantidade = quantidade;
//       }