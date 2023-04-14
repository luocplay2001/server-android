package com.server.controller;

import com.server.dto.CartItemDTO;
import com.server.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.addCartItem(cartItemDTO);
    }
}
