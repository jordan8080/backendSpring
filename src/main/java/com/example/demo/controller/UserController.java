package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";  // Page d'inscription
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Page de connexion
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return "redirect:/login";  // Redirige vers la page de connexion après inscription
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.authenticateUser(username, password)) {
            model.addAttribute("username", username);
            return "home";  // Page d'accueil après connexion
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            return "login";  // Page de connexion avec erreur
        }
    }
}
