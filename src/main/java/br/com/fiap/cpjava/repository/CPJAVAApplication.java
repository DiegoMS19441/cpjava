package br.com.fiap.cpjava.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CPJAVAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPJAVAApplication.class, args);
	}

}
