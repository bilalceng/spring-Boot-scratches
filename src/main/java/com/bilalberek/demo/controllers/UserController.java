package com.bilalberek.demo.controllers;

import com.bilalberek.demo.dto.UserRegistrationDto;
import com.bilalberek.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "index"; // Name of your HTML file (index.html)
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto, Model model, Principal principle) {
        try {
            if(principle != null){
                return "redirect:/home";
            }
            userService.registerNewUser(userRegistrationDto);
            model.addAttribute("message", "User registered successfully!");
            model.addAttribute("user", new UserRegistrationDto()); // Clear the form fields
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
