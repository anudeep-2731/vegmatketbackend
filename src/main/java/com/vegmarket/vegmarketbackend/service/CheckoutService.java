package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dto.Purchase;
import com.vegmarket.vegmarketbackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
