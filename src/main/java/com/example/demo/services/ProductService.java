package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id,Product product);
    public void deleteProduct(Long id);
    List<Product> getLimitedProduct(int limit);
    List<Product> getSortedProduct(String sort);
}