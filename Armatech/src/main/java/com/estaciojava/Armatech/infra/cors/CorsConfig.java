package com.estaciojava.Armatech.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// Permite cors para todas as rotas
                .allowedOrigins("http://172.20.10.2:8081")//Permite requisições de um domínio especifico(forntend)
                .allowedMethods("GET", "POST", "PUT", "DELETE")//Métodos http permitido
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
