package com.example.demo.security;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Resource
    private final CustomUserDetailsService customUserDetailsService;
//    @Resource
//    private final RememberMeServices rememberMeServices;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
//        this.rememberMeServices = rememberMeServices;
    }
    @Bean
    RememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm = TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
        TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("myKey", customUserDetailsService, encodingAlgorithm);
        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.MD5);
        return rememberMe;
    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(rQ -> {
            rQ.requestMatchers("/js/**","/css/**").permitAll();
            rQ.anyRequest().authenticated();

        });
//        http.sessionManagement(sessionAuthenticationStrategy ->
//                sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.authenticationProvider(authenticationProvider());
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.formLogin(form -> form
                .loginPage("/login")
                .permitAll());

        http.rememberMe((remember) -> {
            remember.rememberMeServices(rememberMeServices());
            remember.rememberMeParameter("remember-me");
        });

        http.logout(logout -> logout
                .logoutUrl("/logout") // specify the logout URL
                .logoutSuccessUrl("/") // specify where to redirect after logout
//                .permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"));


        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(customUserDetailsService);
////        provider.setPasswordEncoder(passwordEncoder()); // Use your password encoder here
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
//        return authenticationManagerBuilder.build();
//    }
}
