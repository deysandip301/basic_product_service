package com.example.demo.services;

import com.example.demo.DTOs.FakeStoreProductDto;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://fakestoreapi.com/products";
    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(Objects.requireNonNull(restTemplate.getForObject(API_URL, FakeStoreProductDto[].class)));
        return mapToProduct(fakeStoreProductDtos);
    }

    private List<Product> mapToProduct(List<FakeStoreProductDto> fakeStoreProductDtos) {
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {

            products.add(mapToProduct(fakeStoreProductDto));
        }

        return products;
    }

    protected Product mapToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(Math.random(),fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImage());

        return product;
    }

    private FakeStoreProductDto mapToFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());

        return fakeStoreProductDto;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(API_URL + "/" + id, FakeStoreProductDto.class);
        assert fakeStoreProductDto != null;
        return mapToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.postForObject(API_URL, mapToFakeStoreProductDto(product), FakeStoreProductDto.class);
        assert fakeStoreProductDto != null;
        return mapToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject(API_URL + "/" + id, mapToFakeStoreProductDto(product), FakeStoreProductDto.class);
        assert fakeStoreProductDto != null;
        return mapToProduct(fakeStoreProductDto);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(API_URL + "/" + id);
    }

    @Override
    public List<Product> getLimitedProduct(int limit) {
        FakeStoreProductDto [] fakeStoreProductDtos = restTemplate.getForObject(API_URL, FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(int i = 0; i < limit; i++) {
            assert fakeStoreProductDtos != null;
            products.add(mapToProduct(fakeStoreProductDtos[i]));
        }
        return products;
    }

    @Override
    public List<Product> getSortedProduct(String sort) {
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(Objects.requireNonNull(restTemplate.getForObject(API_URL + "?sort=" + sort , FakeStoreProductDto[].class)));
        return mapToProduct(fakeStoreProductDtos);
    }
}
