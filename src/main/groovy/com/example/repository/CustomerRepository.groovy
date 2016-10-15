package com.example.repository

import com.example.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository extends JpaRepository<Customer, Integer> {}
