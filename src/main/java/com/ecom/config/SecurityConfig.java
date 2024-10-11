package com.ecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Security configuration class for the application.
 * Configures authentication and authorization settings using Spring Security.
 * Project developed by Sahil.
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler; // Handler for successful authentication
    
    @Autowired
    @Lazy
    private AuthFailureHandlerImpl authenticationFailureHandler; // Handler for authentication failure

    /**
     * Bean for password encoding using BCrypt.
     *
     * @return a PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
    }

    /**
     * Bean for UserDetailsService implementation.
     *
     * @return a UserDetailsService instance
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(); // Custom implementation for user details retrieval
    }

    /**
     * Bean for DaoAuthenticationProvider.
     *
     * @return a DaoAuthenticationProvider instance
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService()); // Set user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // Set password encoder
        return authenticationProvider; // Return the configured provider
    }

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object for configuring security settings
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configure CSRF and CORS settings, authorization rules, and form login
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(req -> req.requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/**").permitAll())
            .formLogin(form -> form.loginPage("/signin")
                .loginProcessingUrl("/login")
                // .defaultSuccessUrl("/") // Uncomment to set a default success URL
                .failureHandler(authenticationFailureHandler) // Set failure handler
                .successHandler(authenticationSuccessHandler)) // Set success handler
            .logout(logout -> logout.permitAll()); // Allow logout for all users

        return http.build(); // Build and return the security filter chain
    }

}
