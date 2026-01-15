package com.loginapp.login.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.login.model.Product;
import com.loginapp.login.services.IProductService;

@RestController
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/DetailPage")
    public Product getProductsDetails(@RequestParam Long id, Authentication authentication) {
        return productService.findProductById(id)
                .map(product -> {
                    return product;
                })
                .orElse(null);
    }
}
