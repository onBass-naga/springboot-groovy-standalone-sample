package com.example

import com.example.app.Argument
import com.example.app.ArgumentResolver
import com.example.app.Calculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Hajiboot2BApplication implements CommandLineRunner {

	@Autowired
	ArgumentResolver argumentResolver

	@Autowired
	Calculator calculator

	@Override
	void run(String... args) throws Exception {
		print("Enter 2 numbers like a b : ")
		Argument argument = argumentResolver.resolve(System.in)
		int result = calculator.calc(argument.a, argument.b)

		println("result = ${result}")
	}

	static void main(String[] args) {
		SpringApplication.run(Hajiboot2BApplication.class, args)
	}
}
