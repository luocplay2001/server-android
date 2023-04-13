package com.server.repository;

import com.server.entity.Category;
import com.server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Integer categoryId);
}
