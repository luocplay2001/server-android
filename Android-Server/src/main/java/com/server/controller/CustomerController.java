package com.server.controller;

import com.server.dto.AuthRequest;
import com.server.dto.CustomerDTO;
import com.server.dto.SignupRequest;
import com.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return customerService.login(request);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        return customerService.signup(request);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CustomerDTO dto) {
        return customerService.add(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CustomerDTO dto) {
        return customerService.update(dto);
    }
}
