package com.server.controller;

import com.server.dto.ProductDTO;
import com.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired private ProductService productService;

    @GetMapping("/list/{categoryId}")
    public ResponseEntity<?> findAll(@PathVariable Integer categoryId) {
        return productService.findAll(categoryId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductDTO dto) {
        return productService.addProduct(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductDTO dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("/delete/{categoryId}")
    public void delete(@PathVariable Integer categoryId) {
        productService.deleteProduct(categoryId);
    }
}
