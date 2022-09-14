package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.AddressRepository;
import com.vegmarket.vegmarketbackend.dao.CustomerRespository;
import com.vegmarket.vegmarketbackend.dto.ChangePasswordRequest;
import com.vegmarket.vegmarketbackend.dto.LoginRequest;
import com.vegmarket.vegmarketbackend.dto.RegisterRequest;
import com.vegmarket.vegmarketbackend.entity.Address;
import com.vegmarket.vegmarketbackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public boolean updateCustomer(Customer customer){
        Customer existingCustomer=this.customerRespository.findById(customer.getId()).get();

        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());

        customerRespository.save(existingCustomer);
        return  true;
    }

    public boolean updateAddress(Address address){
        Address existingAddress=this.addressRepository.findById(address.getId()).get();
        existingAddress.setCity(address.getCity());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setState(address.getState());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setZipcode(address.getZipcode());
        addressRepository.save(existingAddress);

        return true;
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

    public void changePassword(ChangePasswordRequest changePasswordRequest){
        Customer customer=this.customerRespository.findByEmail(changePasswordRequest.getEmail());
        customer.setPassword(changePasswordRequest.getPassword());
        customerRespository.save(customer);
    }

    public List<Customer> getCustomers(){
        return this.customerRespository.findAll();
    }
}
