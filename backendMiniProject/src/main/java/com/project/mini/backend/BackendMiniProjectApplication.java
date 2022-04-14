package com.project.mini.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BackendMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMiniProjectApplication.class, args);
	}

}
