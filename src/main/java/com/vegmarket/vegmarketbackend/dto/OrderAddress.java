package com.vegmarket.vegmarketbackend.dto;

import lombok.Data;

import javax.persistence.Column;

@Data

public class OrderAddress {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
