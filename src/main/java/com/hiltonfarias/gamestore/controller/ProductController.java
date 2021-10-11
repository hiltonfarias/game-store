package com.hiltonfarias.gamestore.controller;

import com.hiltonfarias.gamestore.entity.Product;
import com.hiltonfarias.gamestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> listProduct() {
        return ResponseEntity.ok(productService.listAllProducts());
    }
}
