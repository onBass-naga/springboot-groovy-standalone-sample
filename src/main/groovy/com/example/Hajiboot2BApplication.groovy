package com.example

import com.example.domain.Customer
import com.example.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

@SpringBootApplication
class Hajiboot2BApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService

	@Override
	void run(String... args) throws Exception {

		def created = customerService.save(
				new Customer(null, 'Hidetoshi', 'Dekisugi'))
		println("${created} is created!")

		customerService.findAll().each { println(it) }

		Pageable pageable = new PageRequest(1, 2)
		def page = customerService.findAllOrderByName(pageable)

		println("1ページのデータ数: ${page.getSize()}")
		println("現在のページ: ${page.getNumber()}")
		println("全ページ数: ${page.getTotalPages()}")
		println("全データ数: ${page.getTotalElements()}")
		page.getContent().each{ println(it) }


		customerService.findAllOrderByNameDesc().each{ println(it) }
	}

	static void main(String[] args) {
		SpringApplication.run(Hajiboot2BApplication.class, args)
	}
}
