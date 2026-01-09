package com.loginapp.login.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.loginapp.login.services.IProductService;

@Controller
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/DetailPage/{id}")
    public String getProductsDetails(@PathVariable Long id, Model model, Authentication authentication) {
        return productService.findProductById(id)
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
