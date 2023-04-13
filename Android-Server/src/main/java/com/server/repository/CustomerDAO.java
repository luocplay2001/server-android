package com.server.repository;

import com.server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
