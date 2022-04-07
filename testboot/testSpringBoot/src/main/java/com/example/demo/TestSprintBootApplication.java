package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSprintBootApplication {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(TestSprintBootApplication.class, args);
	}

}
