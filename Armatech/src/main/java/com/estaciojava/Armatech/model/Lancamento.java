package com.estaciojava.Armatech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID é representado como uma string de 36 caracteres
    private String id;

    public enum TipoLancamento {
        ENTRADA(0),
        SAIDA(1);

        private final int tipo;

        // Construtor do Enum
        TipoLancamento(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }
    }

    // Propriedade para armazenar o tipo do lançamento
    @Enumerated(EnumType.ORDINAL) // Armazena como String no banco
    private TipoLancamento tipo;

    private double quantidade;

    @Column(name = "data_entrada") // Nome exato da coluna no banco
    private Timestamp dataEntrada;

    @Column(name = "data_saida") // Nome exato da coluna no banco
    private Timestamp dataSaida;

    // Referência à entidade Produto OBS: Preciso de Produtos feito para que tenha essa relação
    @JoinColumn(name = "idProduto", referencedColumnName = "id") // Explicita que a FK é 'idProduto'
    @ManyToOne // Estabelece que vários lançamentos podem referenciar um único produto
    private Produto produto;


    /* Só para visualizar melhor como está no banco:

    create table lancamento(
        id varchar(36) primary key,
        idProduto varchar(36),
        tipo varchar(20), -- armazena como string (ENTRADA/SAIDA)
        quantidade decimal,
        dataEntrada timestamp,
        dataSaida timestamp,
        foreign key (idProduto) references produto(id)
    );

    */
}
