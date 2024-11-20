package com.estaciojava.Armatech.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class LancamentoFilter {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Define o formato explícito
    private LocalDateTime dataComeco;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFim;

}
