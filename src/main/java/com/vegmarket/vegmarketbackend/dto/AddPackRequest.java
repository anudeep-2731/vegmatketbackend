package com.vegmarket.vegmarketbackend.dto;

import com.vegmarket.vegmarketbackend.entity.PackItem;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class AddPackRequest {
    private String packName;
    private   BigDecimal totalQuantity;
    private BigDecimal totalPrice;
    private  int totalItems;
    private String imageUrl;
    private Set<PackItem> packItems;
}
