package com.example.individualproject.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "/")
public class IndexController {
    @GetMapping("/")
    public String home() {
        return "index"; // This will look for a Thymeleaf template named "index.html"
    }
}
