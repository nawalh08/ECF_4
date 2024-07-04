package com.example.ECF_4.controller;

import com.example.ECF_4.entities.User;
import com.example.ECF_4.services.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @GetMapping("/register")

    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("user") User user){
        authService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("login", authService.isLogged());
        model.addAttribute("error", "Invalid username or password!");
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") User user, Model model){
        boolean success = authService.login(user.getUsername(), user.getPassword());

        if(success){
            return "redirect:/";
        }
        else {
            return "redirect:/login";
        }



    }
    @GetMapping("logout")
    public String logout(Model model) {
        authService.logout();
        return "redirect:/login";
    }
}
