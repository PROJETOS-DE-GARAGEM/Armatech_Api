package com.estaciojava.Armatech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table (name = "lancamento")

public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID é representado como uma string de 36 caracteres

    private String id;

    private enum TipoLancamento{
        ENTRADA,
        SAIDA
    };

    private TipoLancamento tipo;

    private int quantidade;

    private Timestamp dataEntrada;
    private Timestamp dataSaida;

    // Referência à entidade Produto OBS: Preciso de Produtos feito para que tenha essa relação
    @JoinColumn(name = "idProduto", referencedColumnName = "id") //Somente para explicitar que a PK é 'idProduto'
    @ManyToOne // Estabelece que vários lançamentos podem referenciar um único produto
    private Produto produto;



/*Só para visualizar melhor como está no banco

    create table lancamento(
        id varchar(36) primary key not null,
        tipo int,
        quantidade decimal not null,
        dataEntrada timestamp,
        dataSaida timestamp,
        idProduto int not null,
        FOREIGN KEY (idproduto) REFERENCES produtos(id)
    );*/
}