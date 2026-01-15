package com.loginapp.login.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.login.model.Product;
import com.loginapp.login.services.IProductService;

@RestController
public class HomeController {
    private final IProductService productService;
    
    public HomeController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> showHome() {
        return productService.findAllProducts();
    }

}
