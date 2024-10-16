package com.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringBootAppApplication.class, args);
		} catch (Exception e) {
			System.err.println("Error thrown: " + e.getMessage());
		}
	}

}
