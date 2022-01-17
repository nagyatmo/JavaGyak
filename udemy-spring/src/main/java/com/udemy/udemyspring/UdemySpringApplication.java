package com.udemy.udemyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class UdemySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemySpringApplication.class, args);
	}

}
