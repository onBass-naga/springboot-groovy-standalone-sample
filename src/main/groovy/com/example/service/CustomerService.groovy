package com.example.service

import com.example.domain.Customer
import com.example.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {
    @Autowired
    CustomerRepository customerRepository

    Customer save(Customer customer) {
        return customerRepository.save(customer)
    }

    List<Customer> findAll() {
        return customerRepository.findAll()
    }
}
