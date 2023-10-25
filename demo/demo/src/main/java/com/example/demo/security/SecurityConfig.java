package com.example.demo.security;
import com.example.demo.security.jwt.JwtAuthenticationFilter_CustomFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter_CustomFilter jwtAuthFilter;
    private final AuthenticationProvider authProvider;


//    @Bean
//    RememberMeServices rememberMeServices() {
//        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm = TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
//        TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("myKey", userDetailsService, encodingAlgorithm);
//        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.MD5);
//        return rememberMe;
//    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(crf -> crf.disable());
        http.authorizeHttpRequests(rQ -> {
            rQ.requestMatchers("/api/v1/auth/**").permitAll();
            rQ.anyRequest().authenticated();

        });

        http.sessionManagement(sessionAuthenticationStrategy ->
                sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authenticationProvider(authProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

//        http.formLogin(form -> form
//                .loginPage("/login")
//                .permitAll());
//
//        http.rememberMe((remember) -> {
//            remember.rememberMeServices(rememberMeServices());
//            remember.rememberMeParameter("remember-me");
//        });
//
//        http.logout(logout -> logout
//                .logoutUrl("/logout") // specify the logout URL
//                .logoutSuccessUrl("/") // specify where to redirect after logout
////                .permitAll()
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID"));
//
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        return http.build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("X-Get-Header"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
