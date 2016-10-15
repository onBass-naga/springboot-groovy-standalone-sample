package com.example.repository

import com.example.domain.Customer
import org.springframework.stereotype.Repository

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@Repository
class CustomerRepository {

    final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>()

    List<Customer> findAll() {
        return new ArrayList<Customer>(customerMap.values())
    }

    Customer findOne(Integer id) {
        return customerMap.get(id)
    }

    Customer save(Customer customer) {
        return customerMap.put(customer.id, customer)
    }

    Customer delete(Integer id) {
        customerMap.remove(id)
    }
}
