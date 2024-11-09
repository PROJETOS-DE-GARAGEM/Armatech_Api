package com.estaciojava.Armatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArmatechApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ArmatechApplication.class, args);
			System.out.println("\n\nAplicacao Rodando");
		} catch (RuntimeException e) {
			System.out.println("Ocorreu um Problema Verificar o Codigo Abaixo");
			throw new RuntimeException(e);
		}
	}

}
