package com.example.demo.services;

//import models.Category;
//import models.Product;
//import java.util.List;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();
    List<Product> getProductsFromCategory(String categoryName);

}