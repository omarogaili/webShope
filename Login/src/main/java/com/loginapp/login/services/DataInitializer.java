package com.loginapp.login.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.loginapp.login.model.Product;
import com.loginapp.login.repository.ProductsRepository;

@Service
public class DataInitializer {
    private final ProductsRepository productsRepository;

    public DataInitializer(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @PostConstruct
    public void initializeData() {
        if (productsRepository.count() == 0) {
            productsRepository.saveAll(java.util.List.of(
                new Product("iPhone 17", "Phone 17 - slitstark, smart och full av möjligheter...", 17000.0, "/images/iphone17.jpeg"),
                new Product("Laptop Pro", "Högpresterande laptop med 16GB RAM och 512GB SSD", 12999.0, "/images/laptop.jpeg"),
                new Product("Trådlös Mus", "Ergonomisk trådlös mus med lång batteritid", 299.0, "/images/mouse.jpeg")
            ));
        }
    }
}