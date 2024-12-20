package com.gdgstudy.jmblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JmblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmblogApplication.class, args);
	}

}
