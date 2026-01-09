package com.loginapp.login.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginapp.login.repository.UserRepository;
import com.loginapp.login.model.User;

import jakarta.validation.Valid;

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
        model.addAttribute("user", new User());
        return "register";
    }

    // jag har hittat den här lösningen på internet för att validera formulärdata med hjälp av @Valid och BindingResult källan är här:
    // https://spring.io/guides/gs/validating-form-input .
    @PostMapping("/users/register")
    public String postUserRegistering(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "register";
        }
        user.setPassword(passwordDCryptor.encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("message", "Användaren har registerat !");
        return "redirect:/";
    }
    
}
