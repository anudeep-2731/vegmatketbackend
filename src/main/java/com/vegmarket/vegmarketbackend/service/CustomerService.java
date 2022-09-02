package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.AddressRepository;
import com.vegmarket.vegmarketbackend.dao.CustomerRespository;
import com.vegmarket.vegmarketbackend.dto.LoginRequest;
import com.vegmarket.vegmarketbackend.dto.RegisterRequest;
import com.vegmarket.vegmarketbackend.entity.Address;
import com.vegmarket.vegmarketbackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private AddressRepository addressRepository;

    public Customer getCustomerByEmail(String email){
        return customerRespository.findByEmail(email);
    }

    public Customer registerCustomer(RegisterRequest registerRequest){
        Customer customer= new Customer();
        customer.setFullName(registerRequest.getFullName());
        customer.setEmail(registerRequest.getEmail());
        customer.setPhone(registerRequest.getPhone());
        customer.setPassword(registerRequest.getPassword());
        return customerRespository.save(customer);
    }

    public Customer loginCustomer(LoginRequest loginRequest){
        Customer customer=customerRespository.findByEmail(loginRequest.getUserEmail());
        if(customer!=null&&customer.getPassword().equals(loginRequest.getPassword()))
            return customer;
        else
            return null;
        //return customer;
    }

    public boolean isUserExists(String email){
        return customerRespository.existsByEmail(email);
    }

    public Optional<Address> getAddress(Long id){
        return addressRepository.findById(id);
    }

    public boolean addAddress(Address address,String Email){
        Customer customer=this.customerRespository.findByEmail(Email);
        customer.addAddress(address);
        customerRespository.save(customer);
        return true;
    }
}
