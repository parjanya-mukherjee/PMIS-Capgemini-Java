package com.parjanya30.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This is the one starting point for the whole REST API.
 *
 * The controller files are separate so that each HTTP method is easy to
 * study. Spring Boot starts all of those controllers from this class.
 */
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}