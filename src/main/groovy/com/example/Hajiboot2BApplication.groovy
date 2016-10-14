package com.example

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Hajiboot2BApplication implements CommandLineRunner {

	@Override
	void run(String... args) throws Exception {
	}

	static void main(String[] args) {
		SpringApplication.run(Hajiboot2BApplication.class, args)
	}
}
