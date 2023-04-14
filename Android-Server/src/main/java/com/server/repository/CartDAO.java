package com.server.repository;

import com.server.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart, Integer> {

    List<Cart> findByCustomerId(Integer customerId);
}
