package com.example

import com.example.domain.Customer
import com.example.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Hajiboot2BApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService

	@Override
	void run(String... args) throws Exception {
		customerService.save(new Customer(1, 'Nobita', 'Nobi'))
		customerService.save(new Customer(2, 'Takeshi', 'Goda'))
		customerService.save(new Customer(3, 'Suneo', 'Honekawa'))

		customerService.findAll().each { println(it) }
	}

	static void main(String[] args) {
		SpringApplication.run(Hajiboot2BApplication.class, args)
	}
}
