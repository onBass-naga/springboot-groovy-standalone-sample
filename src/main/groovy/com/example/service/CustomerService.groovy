package com.example.service

import com.example.domain.Customer
import com.example.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class CustomerService {
    @Autowired
    CustomerRepository customerRepository

    Customer save(Customer customer) {
        return customerRepository.save(customer)
    }

    List<Customer> findAll() {
        return customerRepository.findAll()
    }

    Page<Customer> findAllOrderByName(Pageable pageable) {
        return customerRepository.findAllOrderByName(pageable)
    }

    List<Customer> findAllOrderByNameDesc() {
        return customerRepository.findAllOrderByNameDesc()
    }
}
