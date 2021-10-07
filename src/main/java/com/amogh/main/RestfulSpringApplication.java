package com.amogh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.amogh")
@EnableJpaRepositories(basePackages = "com.amogh.persistance")
@EntityScan(basePackages = "com.amogh.bean")
public class RestfulSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulSpringApplication.class, args);
	}

}
