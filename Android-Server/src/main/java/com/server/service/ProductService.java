package com.server.service;

import com.server.dto.ProductDTO;
import com.server.entity.Product;
import com.server.repository.CategoryDAO;
import com.server.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired private ProductDAO productDAO;
    @Autowired private CategoryDAO categoryDAO;

    public ResponseEntity<?> findAll(Integer categoryId) {
        return ResponseEntity.ok(productDAO.findAllByCategoryId(categoryId));
    }

    public ResponseEntity<?> addProduct(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDesctiption(dto.getDesctiption());
        entity.setImageUrl(dto.getImageUrl());
        entity.setCategory(categoryDAO.findById(dto.getCategoryId()).get());
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<?> updateProduct(ProductDTO dto) {
        Product entity = productDAO.findById(dto.getId()).get();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDesctiption(dto.getDesctiption());
        entity.setImageUrl(dto.getImageUrl());
        entity.setCategory(categoryDAO.findById(dto.getCategoryId()).get());
        return ResponseEntity.ok(entity);
    }

    public void deleteProduct(Integer id) {
        productDAO.deleteById(id);
    }
}
