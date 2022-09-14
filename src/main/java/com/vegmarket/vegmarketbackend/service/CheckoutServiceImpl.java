package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.AddressRepository;
import com.vegmarket.vegmarketbackend.dao.CustomerRespository;
import com.vegmarket.vegmarketbackend.dto.Purchase;
import com.vegmarket.vegmarketbackend.dto.PurchaseResponse;
import com.vegmarket.vegmarketbackend.entity.Address;
import com.vegmarket.vegmarketbackend.entity.Customer;
import com.vegmarket.vegmarketbackend.entity.Order;
import com.vegmarket.vegmarketbackend.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRespository customerRespository;

    private AddressRepository addressRepository;

    public CheckoutServiceImpl(CustomerRespository customerRespository,AddressRepository addressRepository){
        this.customerRespository=customerRespository;
        this.addressRepository=addressRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the order info from dto
        Order order = new Order();
        order.setTotalQuantity(purchase.getOrderRequest().getTotalQuantity());
        order.setTotalPrice(purchase.getOrderRequest().getTotalPrice());
        order.setStatus(purchase.getOrderRequest().getStatus());
        order.setPaymentMethod(purchase.getOrderRequest().getPaymentMethod());

        //System.out.println(order);

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //System.out.println(orderTrackingNumber);

        //populate the order with OrderItems
        Set<OrderItem> orderItems= purchase.getOrderItems();

        orderItems.forEach(item->order.add(item));
        //order.getOrderItems().forEach(item->System.out.println(item.getQuantity()));

        if(purchase.getShippingAddressId()!=null){
        Optional<Address> opaddress=this.addressRepository.findById(purchase.getShippingAddressId());
            Address address =opaddress.get();
            //populate order with billingAddress
            order.setBillingAddress(address);
            order.setShippingAddress(address);
        }




        //Address address= purchase.getShippingAddress();

        Customer customer = customerRespository.findByEmail(purchase.getEmail());

        //populate customer with order
        //Customer customer = purchase.getCustomer();

        //String theEmail=customer.getEmail();

//        if(customerfromDB!=null){
//            customer=customerfromDB;
//        }
       // customer.addAddress(purchase.getShippingAddress());
        customer.add(order);
        //customer.addAddress(address);

        //customerRespository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random uuid number
       return UUID.randomUUID().toString();
    }
}
