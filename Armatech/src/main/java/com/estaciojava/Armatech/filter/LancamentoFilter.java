package com.estaciojava.Armatech.filter;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LancamentoFilter {
    private Timestamp dataComeco;
    private Timestamp dataFim;

}
