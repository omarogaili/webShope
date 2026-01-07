package com.loginapp.login.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginapp.login.repository.UserRepository;
import com.loginapp.login.model.User;



@Controller
public class UserController {
    
    private final UserRepository userRepository;
    private PasswordEncoder passwordDCryptor;

    public UserController(UserRepository userRepository, PasswordEncoder passwordDCryptor) {
        this.userRepository = userRepository;
        this.passwordDCryptor = passwordDCryptor;
    }

    @GetMapping("/users/register")
    public String showRegisterForm(Model model) {
        return "register";
    }
    @PostMapping("/users/register")
    public String postUserRegistering(User user, Model model) {
        user.setPassword(passwordDCryptor.encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("message", "Användaren har registerat !");
        return "redirect:/";
    }
}
