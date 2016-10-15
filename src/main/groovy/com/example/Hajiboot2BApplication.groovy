package com.example

import com.example.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource

@SpringBootApplication
class Hajiboot2BApplication implements CommandLineRunner {

//	@Autowired
//	CustomerService customerService
//
//	@Override
//	void run(String... args) throws Exception {
//		customerService.save(new Customer(1, 'Nobita', 'Nobi'))
//		customerService.save(new Customer(2, 'Takeshi', 'Goda'))
//		customerService.save(new Customer(3, 'Suneo', 'Honekawa'))
//
//		customerService.findAll().each { println(it) }
//	}

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate

	@Override
	void run(String... args) throws Exception {

		String sql = '''
			SELECT
				id, first_name, last_name
			FROM
				customers
			WHERE
				id = :id
		'''

		SqlParameterSource param = new MapSqlParameterSource()
			.addValue("id", 2)
		Customer result = jdbcTemplate.queryForObject(sql, param, {
			rs, rowNum ->
					return new Customer(
							rs.getInt('id'),
							rs.getString('first_name'),
							rs.getString('last_name'))
				} as RowMapper<Customer>
		)

		println(result)
	}

	static void main(String[] args) {
		SpringApplication.run(Hajiboot2BApplication.class, args)
	}
}
