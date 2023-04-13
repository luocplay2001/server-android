package com.server.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double totalAmount;
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
