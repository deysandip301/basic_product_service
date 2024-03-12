package com.example.demo.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private double id;
    private String name;

    public Category(double id, String name) {
        this.id = id;
        this.name = name;
    }

}
