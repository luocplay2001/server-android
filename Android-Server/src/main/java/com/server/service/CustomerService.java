package com.server.service;

import com.server.dto.AuthRequest;
import com.server.dto.CustomerDTO;
import com.server.entity.Customer;
import com.server.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    @Autowired private CustomerDAO customerDAO;

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(customerDAO.findAll());
    }

    public ResponseEntity<?> login(AuthRequest request) {
        Customer customer = customerDAO.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if(customer != null) return ResponseEntity.ok("Login Success");
        return ResponseEntity.ok("Login Fail");
    }

    public ResponseEntity<?> add(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setAddress(dto.getAddress());
        entity.setDob(dto.getDob());
        entity.setCreatedDate(new Date());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
        entity.setPhone(dto.getPhone());
        customerDAO.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<?> update(CustomerDTO dto) {
        Customer entity = customerDAO.findById(dto.getId()).get();
        entity.setAddress(dto.getAddress());
        entity.setDob(dto.getDob());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
        entity.setPhone(dto.getPhone());
        customerDAO.save(entity);
        return ResponseEntity.ok(entity);
    }
}
