package com.server.repository;

import com.server.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDAO extends JpaRepository<CartItem, Integer> {
}
