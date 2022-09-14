package com.vegmarket.vegmarketbackend.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String email;
    private String password;
}
