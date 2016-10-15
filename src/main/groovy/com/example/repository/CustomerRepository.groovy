package com.example.repository

import com.example.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.annotation.PostConstruct

@Repository
@Transactional
class CustomerRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate

    SimpleJdbcInsert insert

    @PostConstruct
    void init() {
        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
            .withTableName('customers')
            .usingGeneratedKeyColumns('id')
    }

    private static RowMapper<Customer> customerRowMapper = {
        rs, rowNum ->
        return new Customer(
                rs.getInt('id'),
                rs.getString('first_name'),
                rs.getString('last_name'))
    } as RowMapper<Customer>

    private static final String SQL_SELECT_ALL = '''
			SELECT
				id, first_name, last_name
			FROM
				customers
		'''

    List<Customer> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, customerRowMapper)
    }

    private static final String SQL_SELECT_BY_ID = '''
			SELECT
				id, first_name, last_name
			FROM
				customers
			WHERE
				id = :id
		'''

    Customer findOne(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id)
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, param, customerRowMapper)
    }

    private static final String SQL_UPDATE = '''
			UPDATE
				customers
			SET
				first_name = :firstName
				, last_name = :lastName
			WHERE
				id = :id
		'''

    Customer save(Customer customer) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer)

        if (customer.id == null) {
            Number key = insert.executeAndReturnKey(param)
            customer.id = key.intValue()
        } else {
            jdbcTemplate.update(SQL_UPDATE, param)
        }

        return customer
    }

    private static final String SQL_DELETE = '''
			DELETE
				customers
			WHERE
				id = :id
		'''

    void delete(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id)

        jdbcTemplate.update(SQL_DELETE, param)
    }
}
