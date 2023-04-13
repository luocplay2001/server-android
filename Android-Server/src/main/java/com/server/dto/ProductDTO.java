package com.server.dto;

import com.server.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private String desctiption;
    private String imageUrl;
    private Integer categoryId;
}
