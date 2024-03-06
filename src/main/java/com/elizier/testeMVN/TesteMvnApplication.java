package com.elizier.testeMVN;

import com.elizier.testeMVN.infraestrutura.adaptadores.repositories.SpringFreteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SpringFreteRepository.class)
public class TesteMvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteMvnApplication.class, args);
	}

}
