package com.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    // Route for the home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "home"; // This maps to src/main/resources/templates/home.html
    }

    // Route for the sign-up page (GET request)
    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("title", "Sign Up");
        return "sign-up"; // This maps to src/main/resources/templates/sign-up.html
    }

    // Route for handling sign-up form submission (POST request)
    @PostMapping("/sign-up")
    public String handleSignUp(Model model) {
        // Logic for sign-up form submission (placeholder)
        model.addAttribute("message", "Sign-Up Successful!");
        return "redirect:/"; // Redirect to home page after sign-up
    }

    // Route for the sign-in page (GET request)
    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("title", "Sign In");
        return "sign-in"; // This maps to src/main/resources/templates/sign-in.html
    }

    // Route for handling sign-in form submission (POST request)
    @PostMapping("/sign-in")
    public String handleSignIn(Model model) {
        // Logic for sign-in form submission (placeholder)
        model.addAttribute("message", "Sign-In Successful!");
        return "redirect:/"; // Redirect to home page after sign-in
    }
}
