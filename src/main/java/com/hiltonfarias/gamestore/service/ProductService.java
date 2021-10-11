package com.hiltonfarias.gamestore.service;

import com.hiltonfarias.gamestore.entity.Product;
import com.hiltonfarias.gamestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
