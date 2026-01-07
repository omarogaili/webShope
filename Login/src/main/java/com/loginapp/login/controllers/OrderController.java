package com.loginapp.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    
    @GetMapping("/user/orders")
    public String showOrders() {
        return "orders";
    }
}
