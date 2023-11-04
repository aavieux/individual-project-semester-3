package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
class LoginController {
    @GetMapping()
    String login() {
        return "login";
    }
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


