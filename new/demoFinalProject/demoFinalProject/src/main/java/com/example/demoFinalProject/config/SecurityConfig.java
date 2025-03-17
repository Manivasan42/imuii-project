package com.example.demoFinalProject.config;

import com.example.demoFinalProject.service.MyUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(MyUserService userService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF (not recommended for production)
                .authorizeHttpRequests(auth -> auth
                        // Use requestMatchers instead of antMatchers (Spring Security 5.x)
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()  // Allow access to login and register
                        .anyRequest().authenticated()  // Require authentication for all other pages
                )
                .formLogin(login -> login
                        .loginPage("/user/login")  // The login page URL
                        .loginProcessingUrl("/perform_login")  // URL to submit the login form
                        .defaultSuccessUrl("/user/userHome", true)  // Redirect to user home on success
                        .permitAll()  // Allow all users to access the login page
                )
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Logout URL
                        .logoutSuccessUrl("/user/login?logout=true")  // Redirect after successful logout
                        .permitAll()
                );

        return http.build();
    }
}