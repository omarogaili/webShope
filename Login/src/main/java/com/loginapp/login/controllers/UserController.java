package com.loginapp.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginapp.login.repository.UserRepository;
import com.loginapp.login.model.User;



@Controller
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/register")
    public String showRegisterForm(Model model) {
        return "register";
    }
    @PostMapping("/users/register")
    public String postUserRegistering(User user, Model model) {
        userRepository.save(user);
        model.addAttribute("message", "Användaren har registerat !");
        return "redirect:/";
    }
}
