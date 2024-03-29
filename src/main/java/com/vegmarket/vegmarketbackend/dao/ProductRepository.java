package com.vegmarket.vegmarketbackend.dao;

import com.vegmarket.vegmarketbackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Product findByName(@RequestParam("name") String name);


    Page<Product> findByNameContaining(@RequestParam("name") String name,Pageable pageable);


}
