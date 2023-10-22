package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
class LoginController {
    @GetMapping()
    String login() {
        return "login";
    }

//    @PostMapping()
//    public String authenticate(@RequestParam String username, @RequestParam String password) {
//        try {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
//            System.out.println("Here authenticates---------------------------------------------- FROM POST METHOD FUNCTION");
//            Authentication authenticatedUser = daoAuthenticationProvider.authenticate(authentication);
//            System.out.println("Here authenticates---------------------------------------------- FROM POST METHOD FUNCTION");
//            // Authentication successful
//            SecurityContextHolder.getContext().setAuthentication(authenticatedUser); // Set authentication in SecurityContext
//            return "redirect:/";
//        } catch (Exception ex) {
//            // Authentication failed
//            return "redirect:/login";
//        }
//    }



}
