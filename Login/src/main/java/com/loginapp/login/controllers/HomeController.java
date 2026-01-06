package com.loginapp.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loginapp.login.repository.ProductsRepository;


@Controller
public class HomeController {
    private final ProductsRepository productsRepository;
    public HomeController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @GetMapping("/")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productsRepository.findAll());
        return "home";
    }
}
