package com.vegmarket.vegmarketbackend.dao;

import com.vegmarket.vegmarketbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface CustomerRespository extends JpaRepository<Customer,Long> {

    Customer findByEmail(String theEmail);

    boolean existsByEmail(String email);

}
