package com.loginapp.login.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.loginapp.login.repository.ProductsRepository;

@Controller
public class ProductController {
    private final ProductsRepository productsRepository;

    public ProductController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productsRepository.findAll());
        return "home";
    }

    @GetMapping("/DetailPage/{id}")
    public String getProductsDetails(@PathVariable Long id, Model model, Authentication authentication) {
        return productsRepository.findById(id)
                .map(prod -> {
                    model.addAttribute("product", prod);
                    if (authentication != null && authentication.isAuthenticated()) {
                        model.addAttribute("cart", "inCart");
                    }
                    return "detailPage";
                })
                .orElse("redirect:/");
    }
}
