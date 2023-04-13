package com.server.controller;

import com.server.dto.CategoryDTO;
import com.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO dto) {
        return categoryService.addCategory(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO dto) {
        return categoryService.updateCategory(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void updateCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
