package com.loginapp.login.services;

import jakarta.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginapp.login.model.Product;
import com.loginapp.login.model.User;
import com.loginapp.login.repository.ProductsRepository;
import com.loginapp.login.repository.UserRepository;

@Service
public class DataInitializer {
    private final ProductsRepository productsRepository;
    private final UserRepository userRepository;
        private PasswordEncoder passwordDCryptor;

    public DataInitializer(ProductsRepository productsRepository, UserRepository userRepository, PasswordEncoder passwordDCryptor) {
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
        this.passwordDCryptor = passwordDCryptor;
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