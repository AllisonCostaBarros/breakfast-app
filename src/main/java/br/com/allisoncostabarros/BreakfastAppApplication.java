package br.com.allisoncostabarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.allisoncostabarros.repository")
@SpringBootApplication
@EntityScan(basePackages = { "br.com.allisoncostabarros.model" })
public class BreakfastAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakfastAppApplication.class, args);
	}

}
