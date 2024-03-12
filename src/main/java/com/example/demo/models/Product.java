package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;


    public void setCategory(double random, String category) {
        this.category = new Category(random, category);
    }


}