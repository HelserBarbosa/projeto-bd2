package br.com.unifacisa.projetobd2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Projetobd2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projetobd2Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return (args) -> {
		};
	}

}
