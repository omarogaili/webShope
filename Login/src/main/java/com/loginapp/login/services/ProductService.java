package com.loginapp.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loginapp.login.model.Product;
import com.loginapp.login.repository.ProductsRepository;

@Service
public class ProductService implements IProductService {
    private final ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productsRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productsRepository.findById(id);
    }
}
