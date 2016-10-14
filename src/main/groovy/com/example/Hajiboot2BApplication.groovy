package com.example

import com.example.app.Argument
import com.example.app.ArgumentResolver
import com.example.app.Calculator
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Import

@EnableAutoConfiguration
@Import(AppConfig.class)
class Hajiboot2BApplication {

	static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(
				Hajiboot2BApplication, args)

		ArgumentResolver resolver = context.getBean(ArgumentResolver.class)
		print("Enter 2 numbers like a b : ")
		Argument argument = resolver.resolve(System.in)

		Calculator calculator = context.getBean(Calculator.class)
		int result = calculator.calc(argument.a, argument.b)

		println("result = ${result}")
	}
}
