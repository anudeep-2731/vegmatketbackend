package com.vegmarket.vegmarketbackend.controller;


import com.vegmarket.vegmarketbackend.dao.CustomerRespository;
import com.vegmarket.vegmarketbackend.entity.Customer;
import com.vegmarket.vegmarketbackend.entity.Order;
import com.vegmarket.vegmarketbackend.entity.Product;
import com.vegmarket.vegmarketbackend.service.CustomerService;
import com.vegmarket.vegmarketbackend.service.OrderService;
import com.vegmarket.vegmarketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4201")
@RestController
@RequestMapping("/api/productmanagement")
public class ProductRestController {


    @Autowired
    ProductService productService;

    @Autowired
    CustomerRespository customerRespository;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;


    @GetMapping("/hello")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){return customerRespository.findAll(); }


    @GetMapping("/getcustomer/{email}")
    public Customer getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }
    @GetMapping("/getproducts")
    public List<Product> getProducts(){
       return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PostMapping("/insertproduct")
    public Product setProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PutMapping("/orderStatus")
    public boolean updateStatus(@RequestBody Order order){
        return orderService.setStatus(order);
    }


}
