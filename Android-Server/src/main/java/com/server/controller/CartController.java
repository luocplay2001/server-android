package com.server.controller;

import com.server.dto.CartItemDTO;
import com.server.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.addCartItem(cartItemDTO);
    }

    @GetMapping("/view/{customerId}")
    public ResponseEntity<?> view(@PathVariable Integer customerId) {
        return cartService.viewCart(customerId);
    }

    @GetMapping("/checkout/{customerId}")
    public ResponseEntity<?> checkout(@PathVariable Integer customerId) {
        return cartService.checkout(customerId);
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<?> history(@PathVariable Integer customerId) {
        return cartService.history(customerId);
    }
}
