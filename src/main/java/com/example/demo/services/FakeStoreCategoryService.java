package com.example.demo.services;

import com.example.demo.DTOs.FakeStoreProductDto;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private final FakeStoreProductService fakeStoreProductService;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://fakestoreapi.com/products";

    public FakeStoreCategoryService(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @Override
    public List<Category> getAllCategory() {
        String[] categories = restTemplate.getForObject(API_URL + "/categories", String[].class);
        List<Category> categoryList = new ArrayList<>();
        assert categories != null;
        for(String category : categories) {
            categoryList.add(new Category(Math.random(), category));
        }
        return categoryList;
    }

    @Override
    public List<Product> getProductsFromCategory(String categoryName) {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(API_URL + "/category/" + categoryName, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();

        assert fakeStoreProductDtos != null;
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(
                    fakeStoreProductService.mapToProduct(fakeStoreProductDto));
        }

        return products;
    }

}
