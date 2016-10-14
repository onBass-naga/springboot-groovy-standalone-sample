package com.example

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

		Scanner scanner = new Scanner(System.in)
		print("Enter 2 numbers like a b : ")
		int a = scanner.nextInt()
		int b = scanner.nextInt()

		Calculator calculator = context.getBean(Calculator.class)
		int result = calculator.calc(a, b)

		println("result = ${result}")
	}
}
