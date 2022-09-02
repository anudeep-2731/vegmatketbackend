package com.vegmarket.vegmarketbackend.dto;

import com.vegmarket.vegmarketbackend.entity.Address;
import com.vegmarket.vegmarketbackend.entity.Customer;
import com.vegmarket.vegmarketbackend.entity.Order;
import com.vegmarket.vegmarketbackend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private String email;

    private Long shippingAddressId;
    private Long billingAddressId;
    private OrderRequest orderRequest;

    private Set<OrderItem> orderItems;


}
