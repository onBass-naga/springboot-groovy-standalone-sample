package com.example

import com.example.app.Frontend
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class Hajiboot2BApplication {

	static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(
				Hajiboot2BApplication, args)

		Frontend frontend = context.getBean(Frontend.class)
		frontend.run()
	}
}
