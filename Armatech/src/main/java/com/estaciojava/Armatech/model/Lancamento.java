package com.estaciojava.Armatech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private Integer tipo;
    private Integer quantidade;

    // Referência à entidade Produto OBS: Preciso de Produtos feito para que tenha essa relação
    @JoinColumn(name = "idProduto", referencedColumnName = "id") //Somente para explicitar que a PK é 'idProduto'
    @ManyToOne // Estabelece que vários lançamentos podem referenciar um único produto
    private Produto produto;

    /*Só para visualizar melhor como está no banco

    create table lancamento(
        id int primary key not null,
        tipo int,
        quantidade numeric not null,
        idProduto int not null,
        FOREIGN KEY (idproduto) REFERENCES produtos(id)
    );*/
}