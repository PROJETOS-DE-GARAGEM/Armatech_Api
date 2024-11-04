package com.estaciojava.Armatech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private String tamanho;
    private Double preco;
    private TipoTamanho tipo;

    public enum TipoTamanho {
    //No POST de cadastro de produto o enum só está reconhecendo os tipos LETRA e NUMERICO como "0" e "1".
    //O valor de tipo não está passando para a tabela de lançamento corretamento, mesmo selecionado o tipo "1", ele só registra
        //tipo "0" no lançamento.
        LETRA(1),
        NUMERICO(2);

        private final int tipo;
        //Construtor enum tipo
        TipoTamanho(int tipo) {
            this.tipo = tipo;
        }

        public int getTipo() {
            return tipo;
        }
    }

    private enum OpcoesTamanhos {
        //LETRA
        PP("PP"),
        P("P"),
        M("M"),
        G("G"),
        GG("GG"),

        //NUMERICO
        TAM36_38("36/38"),
        TAM38_40("38/40"),
        TAM40_42("40/42"),
        TAM42_44("42/44"),
        TAM44_46("44/46");

        private final String tamanho;
        //Construtor enum tamanho
        OpcoesTamanhos(String tamanho) { this.tamanho = tamanho; }
    }

    //Referência o relacionamento da entidade Produto á entidade Lançamento
    //Toda lista de Lançamento associada ao idProduto será deletada ao excluír o produto.
    @OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Lancamento> lancamento;
}


