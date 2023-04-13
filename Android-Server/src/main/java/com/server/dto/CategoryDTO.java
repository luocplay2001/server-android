package com.server.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private String imageUrl;
}
