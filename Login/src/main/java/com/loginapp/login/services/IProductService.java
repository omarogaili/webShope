package com.loginapp.login.services;

import java.util.List;

import java.util.Optional;

import com.loginapp.login.model.Product;

public interface IProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    //! TO DO : Add methods for saving and deleting products
    // Product saveProduct(Product product)
    // void deleteProductById(Long id)
}
