package com.entrajuda.museu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.baeldung.persistence.repo") 
@EntityScan("com.baeldung.persistence.model")
@SpringBootApplication(scanBasePackages={"com.entrajuda.museu"})
public class MuseuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseuApplication.class, args);
	}


}
