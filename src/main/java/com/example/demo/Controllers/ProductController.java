package com.example.demo.Controllers;

import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return  "Product with id " + id + " has been deleted";
    }

    @GetMapping("/limited/{limit}")
    public List<Product> getLimitedProducts(@PathVariable("limit") int limit) {
        return productService.getLimitedProduct(limit);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts(@RequestParam("order") String sort) {
        return productService.getSortedProduct(sort);
    }

}
