package com.example.demo.controllers;
import com.example.demo.models.Friendship;
import com.example.demo.models.User;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.util.List;

@Controller
@RequestMapping("/")
//@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public IndexController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;

    }

    @GetMapping
    public String home(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User authenticatedUser = userService.getUserByEmail(userDetails.getUsername());

        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allBooks", bookService.getAllBooks());
        model.addAttribute("allFriends", userService.getAllFriends(authenticatedUser));

        return "index"; // This will look for a Thymeleaf template named "index.html"
    }

//    @GetMapping("/logout")
//    String logout(){
//        return Ht;
//    }
}
