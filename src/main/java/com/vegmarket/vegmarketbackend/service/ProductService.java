package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.ProductRepository;
import com.vegmarket.vegmarketbackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findByName(product.getName());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setUnitsInStocks(product.getUnitsInStocks());
        productRepository.save(existingProduct);
        return existingProduct;
    }

}
