package com.example.demo.security.jwt.auth;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.security.jwt.auth.requests.AuthenticationRequest;
import com.example.demo.security.jwt.auth.requests.RegisterRequest;
import com.example.demo.security.jwt.auth.responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService_TokenService jwtServiceTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
            .first_name(request.getFirst_name())
            .last_name(request.getLast_name())
            .email(request.getEmail())
            .password(request.getPassword())
            .role(request.getRole()).build();

        userRepository.addUser(user.getRole().toString(), user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getPhone_number(),
                user.getF_genre().toString(),user.getF_author().getId(),user.getF_book().getId());
        var jwtToken =jwtServiceTokenService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
        //TODO
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.getUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken =jwtServiceTokenService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
