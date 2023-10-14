package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@RequestMapping("/myprofile")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //@PreAuthorize("permitAll()")
    @GetMapping()
    public String userProfile(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User authenticatedUser = userService.getUserByEmail(userDetails.getUsername());

        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("authenticatedUser",authenticatedUser);
        model.addAttribute("allFriends", userService.getAllFriends(authenticatedUser));

        return "accountOverview";
    }

    @GetMapping("/allusers") // MyProfile/allUsers
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public void addUser(){
        //....
    }

}
