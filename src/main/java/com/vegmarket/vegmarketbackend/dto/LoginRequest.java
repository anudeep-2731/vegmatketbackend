package com.vegmarket.vegmarketbackend.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String userEmail;
    private String password;
}
