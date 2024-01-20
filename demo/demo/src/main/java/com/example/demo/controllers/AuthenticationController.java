package com.example.demo.controllers;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.security.jwt.auth.requests.AuthenticationRequest;
import com.example.demo.security.jwt.auth.responses.AuthenticationResponse;
import com.example.demo.security.jwt.auth.AuthenticationService;
import com.example.demo.security.jwt.auth.requests.RegisterRequest;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    private final JwtService_TokenService token_service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
    @PostMapping("/tokenvalidation")
    public ResponseEntity<Boolean> isTokenValid(@RequestBody Map<String, String> requestBody,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        String token = requestBody.get("token");

        // Check if the token is valid using the JwtService_TokenService
        boolean isValid = token_service.isTokenValid(token, userDetails);

        return ResponseEntity.ok(isValid);
    }
    @PostMapping("/tokenexpired")
    public ResponseEntity<Object> isTokenExpired(@RequestBody Map<String, String> requestBody) {
        try {
            if (!token_service.isTokenExpired(requestBody.get("token"))) {
                return ResponseEntity.ok(false);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(true);// is expired
        } catch (JwtException jwtException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("There was a problem with the authorisation");
        }
    }

}
