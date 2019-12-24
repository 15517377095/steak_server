package com.steak.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private Integer permissions;
}
