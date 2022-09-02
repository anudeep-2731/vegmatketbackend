package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.OrderRepository;
import com.vegmarket.vegmarketbackend.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public boolean setStatus(Order order){
        Order existingOrder=orderRepository.findById(order.getId()).orElse(null);
        existingOrder.setStatus(order.getStatus());
        orderRepository.save(existingOrder);
        return true;
    }
}
