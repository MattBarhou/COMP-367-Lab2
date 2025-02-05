package com.example.comp367_lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        LocalTime now = LocalTime.now();
        String greeting = now.getHour() < 12 ? "Good morning" : "Good afternoon";
        model.addAttribute("message", greeting + ", YourName, Welcome to COMP367");
        return "index";
    }
}
