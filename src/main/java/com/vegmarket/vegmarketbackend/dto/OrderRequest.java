package com.vegmarket.vegmarketbackend.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class OrderRequest {
    private  int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
}
