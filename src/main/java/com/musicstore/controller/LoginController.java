package com.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String userpass) {
        // Since we disabled security, just redirect to home page
        // In a real application, you would validate credentials here
        return "redirect:/";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "logoutsuccess";
    }
}
