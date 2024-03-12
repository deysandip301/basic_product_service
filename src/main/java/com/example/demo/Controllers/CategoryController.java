package com.example.demo.Controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsFromCategory(@PathVariable("categoryName") String categoryName) {
        return categoryService.getProductsFromCategory(categoryName);
    }

}
