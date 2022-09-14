package com.vegmarket.vegmarketbackend.controller;

import com.vegmarket.vegmarketbackend.dto.ChangePasswordRequest;
import com.vegmarket.vegmarketbackend.dto.LoginRequest;
import com.vegmarket.vegmarketbackend.dto.OrderAddress;
import com.vegmarket.vegmarketbackend.dto.RegisterRequest;
import com.vegmarket.vegmarketbackend.entity.Address;
import com.vegmarket.vegmarketbackend.entity.Customer;
import com.vegmarket.vegmarketbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/customermanagement")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getcustomer/{email}")
    public Customer getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

    @PostMapping("/updateCustomer")
    public boolean updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @PostMapping(value="/register")
    public Customer registerCustomer(@RequestBody RegisterRequest customer){
        return customerService.registerCustomer(customer);
    }
    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody LoginRequest loginRequest){
        return customerService.loginCustomer(loginRequest);
    }

    @GetMapping("/checkCustomer/{email}")
    public boolean checkCustomer(@PathVariable String email){
        return customerService.isUserExists(email);
    }

    @PostMapping("/address")
    public OrderAddress getAddress(@RequestBody OrderAddress address){
        return address;
    }

    @GetMapping("/address/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id){
        return customerService.getAddress(id);
    }

    @PostMapping("addAddress/{email}")
    public boolean addAddress(@RequestBody Address address,@PathVariable String email){
        return customerService.addAddress(address,email);
    }

    @PostMapping("/updateAddress")
    public boolean updateAddress(@RequestBody Address address){
        return customerService.updateAddress(address);
    }

    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        this.customerService.changePassword(changePasswordRequest);
        return true;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
       return this.customerService.getCustomers();
    }
}
