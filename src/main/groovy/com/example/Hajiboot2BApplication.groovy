package com.example

import com.example.app.Frontend
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

		Frontend frontend = context.getBean(Frontend.class)
		frontend.run()
	}
}
