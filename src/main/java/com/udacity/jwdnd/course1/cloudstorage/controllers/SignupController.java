package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

import lombok.AllArgsConstructor;

@Controller @RequestMapping("/signup")
@AllArgsConstructor
public class SignupController {
    private UserService userService;

    @GetMapping
    public String getSignupPage(User user) { return "pages/signup"; }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model) {
        try {
            userService.insert(user);
            model.addAttribute("signupSuccess", true);
            return "pages/signup";
        } catch (IllegalArgumentException e) {
            model.addAttribute("signupError", e.getMessage());
            return "pages/signup";
        }
    }
}