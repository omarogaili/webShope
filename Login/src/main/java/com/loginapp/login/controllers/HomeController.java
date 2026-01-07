package com.loginapp.login.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loginapp.login.services.IProductService;

@Controller
public class HomeController {
    private final IProductService productService;
    
    public HomeController(IProductService productService) {
        this.productService = productService;
    }

    
    @GetMapping("/")
    public String showHome(Authentication authentication, Model model) {
        model.addAttribute("products", productService.findAllProducts());
        boolean isAuthenticated = authentication != null && authentication.isAuthenticated();
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "home";
    }

}
