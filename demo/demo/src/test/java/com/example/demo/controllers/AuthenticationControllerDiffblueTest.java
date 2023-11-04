package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.models.User;
import com.example.demo.models.enums.Role;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.security.jwt.auth.AuthenticationService;
import com.example.demo.security.jwt.auth.requests.AuthenticationRequest;
import com.example.demo.security.jwt.auth.requests.RegisterRequest;
import com.example.demo.security.jwt.auth.responses.AuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthenticationController.class})
@ExtendWith(SpringExtension.class)
class AuthenticationControllerDiffblueTest {
    @Autowired
    private AuthenticationController authenticationController;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private JwtService_TokenService jwtService_TokenService;

    /**
     * Method under test: {@link AuthenticationController#register(RegisterRequest)}
     */
    @Test
    void testRegister() throws Exception {
        when(authenticationService.register(Mockito.<RegisterRequest>any()))
                .thenReturn(AuthenticationResponse.builder().token("ABC123").build());

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("jane.doe@example.org");
        registerRequest.setFirst_name("Jane");
        registerRequest.setLast_name("Doe");
        registerRequest.setPassword("iloveyou");
        registerRequest.setPhone_number("6625550144");
        registerRequest.setProfile_pic_url("https://example.org/example");
        registerRequest.setRole(Role.USER);
        String content = (new ObjectMapper()).writeValueAsString(registerRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\"}"));
    }

    /**
     * Method under test: {@link AuthenticationController#authenticate(AuthenticationRequest)}
     */
    @Test
    void testAuthenticate() throws Exception {
        when(authenticationService.authenticate(Mockito.<AuthenticationRequest>any()))
                .thenReturn(AuthenticationResponse.builder().token("ABC123").build());

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("jane.doe@example.org");
        authenticationRequest.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\"}"));
    }

    /**
     * Method under test: {@link AuthenticationController#isTokenValid(Map, UserDetails)}
     */
    @Test
    void testIsTokenValid() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: java.lang.IllegalStateException: No primary or single unique constructor found for interface org.springframework.security.core.userdetails.UserDetails
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   java.lang.IllegalStateException: No primary or single unique constructor found for interface org.springframework.security.core.userdetails.UserDetails
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(new RunAsImplAuthenticationProvider());
        ProviderManager authenticationManager = new ProviderManager(providers);
        UserRepository userRepository = mock(UserRepository.class);
        AuthenticationService authService = new AuthenticationService(userRepository, new JwtService_TokenService(),
                authenticationManager);

        JwtService_TokenService token_service = mock(JwtService_TokenService.class);
        when(token_service.isTokenValid(Mockito.<String>any(), Mockito.<UserDetails>any())).thenReturn(true);
        AuthenticationController authenticationController = new AuthenticationController(authService, token_service);
        HashMap<String, String> requestBody = new HashMap<>();
        ResponseEntity<Boolean> actualIsTokenValidResult = authenticationController.isTokenValid(requestBody, new User());
        verify(token_service).isTokenValid(Mockito.<String>any(), Mockito.<UserDetails>any());
        assertEquals(200, actualIsTokenValidResult.getStatusCodeValue());
        assertTrue(actualIsTokenValidResult.getBody());
        assertTrue(actualIsTokenValidResult.getHeaders().isEmpty());
    }
}

