package com.vegmarket.vegmarketbackend.controller;

import com.vegmarket.vegmarketbackend.dto.Purchase;
import com.vegmarket.vegmarketbackend.dto.PurchaseResponse;
import com.vegmarket.vegmarketbackend.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){

        this.checkoutService=checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeorder(@RequestBody Purchase purchase ){
        PurchaseResponse purchaseResponse= checkoutService.placeOrder(purchase);

        return purchaseResponse;
        //return purchase;
    }
}
