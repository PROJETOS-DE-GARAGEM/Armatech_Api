package com.estaciojava.Armatech.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Este código configura o CORS para permitir que o front-end para uma URL especificada  envie requisições GET e POST para qualquer endpoint da aplicação.
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// Permite cors para todas as rotas
                .allowedOrigins("http://192.168.1.10:8081")//Permite requisições de um domínio especifico(forntend)
                .allowedMethods("GET", "POST")//Métodos http permitido
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
