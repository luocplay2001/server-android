package com.server.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private Date dob;
    private Date createdDate;
}
