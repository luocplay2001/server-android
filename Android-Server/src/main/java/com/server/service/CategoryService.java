package com.server.service;

import com.server.dto.CategoryDTO;
import com.server.entity.Category;
import com.server.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired private CategoryDAO categoryDAO;

    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(categoryDAO.findAll());
    }

    public ResponseEntity<?> addCategory(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        categoryDAO.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<?> updateCategory(CategoryDTO dto) {
        Category entity = categoryDAO.getById(dto.getId());
        entity.setName(dto.getName());
        categoryDAO.save(entity);
        return ResponseEntity.ok(entity);
    }

    public void deleteCategory(Integer id) {
        categoryDAO.deleteById(id);
    }
}
