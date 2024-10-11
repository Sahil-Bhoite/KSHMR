package com.ecom.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class handles successful authentication.
 * It implements AuthenticationSuccessHandler to customize the response after successful login.
 * Project developed by Sahil.
 */
@Service
public class AuthSucessHandlerImpl implements AuthenticationSuccessHandler {

    /**
     * Called when authentication is successful.
     *
     * @param request       the HttpServletRequest object
     * @param response      the HttpServletResponse object
     * @param authentication the Authentication object containing user details
     * @throws IOException      if an input or output error is detected
     * @throws ServletException if the request for the POST could not be handled
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Get the user's granted authorities (roles)
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Convert the authorities to a set of role strings
        Set<String> roles = AuthorityUtils.authorityListToSet(authorities);

        // Redirect user based on their role
        if (roles.contains("ROLE_ADMIN")) {
            // If user is an admin, redirect to the admin dashboard
            response.sendRedirect("/admin/");
        } else {
            // Otherwise, redirect to the home page
            response.sendRedirect("/");
        }
    }
}
