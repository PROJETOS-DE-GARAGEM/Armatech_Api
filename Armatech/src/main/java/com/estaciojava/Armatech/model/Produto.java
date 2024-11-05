package com.estaciojava.Armatech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        LETRA(0), //Representa no BD o tipo "0" que é os tamanhos identificado por "LETRA"
        NUMERICO(1); //Representa no BD o tipo "1" que é os tamanhos identificado por "NUMERICO"

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
        //LETRA(0)
        PP("PP"),
        P("P"),
        M("M"),
        G("G"),
        GG("GG"),

        //NUMERICO(1)
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
    //FetchTypeLazy ele ajuda para que não seja carregado automaticamente os dados do lançamento quando um Produto for buscado.
    @OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore //Faz com que no metodo "GET" não seja necessário carregar também os dados do lançamento.
    private List<Lancamento> lancamento;
}


