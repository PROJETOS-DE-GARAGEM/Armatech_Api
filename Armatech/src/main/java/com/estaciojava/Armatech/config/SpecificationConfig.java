package com.estaciojava.Armatech.config;


import com.estaciojava.Armatech.specification.ExemploSpecification;
import com.estaciojava.Armatech.specification.LancamentoSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpecificationConfig {

    @Bean
    public ExemploSpecification exemploSpecification() {
        return new ExemploSpecification();
    }

    @Bean
    public LancamentoSpecification lancamentoSpecification(){
        return  new LancamentoSpecification();
    }
}
