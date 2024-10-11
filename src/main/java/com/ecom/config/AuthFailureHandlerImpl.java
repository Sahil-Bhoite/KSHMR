package com.ecom.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;
import com.ecom.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class handles authentication failures.
 * It extends SimpleUrlAuthenticationFailureHandler to customize the failure response.
 * Project developed by Sahil.
 */
@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserRepository userRepository; // Repository to interact with user data

    @Autowired
    private UserService userService; // Service to manage user-related operations

    /**
     * Handles authentication failure by checking user details and determining the reason for failure.
     *
     * @param request   the HttpServletRequest object
     * @param response  the HttpServletResponse object
     * @param exception the AuthenticationException thrown during authentication
     * @throws IOException      if an input or output error is detected
     * @throws ServletException if the request for the POST could not be handled
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // Retrieve the username (email) from the request
        String email = request.getParameter("username");

        // Find the user details based on the provided email
        UserDtls userDtls = userRepository.findByEmail(email);

        if (userDtls != null) {
            // Check if the user's account is enabled
            if (userDtls.getIsEnable()) {

                // Check if the user's account is not locked
                if (userDtls.getAccountNonLocked()) {

                    // Check the number of failed attempts
                    if (userDtls.getFailedAttempt() < AppConstant.ATTEMPT_TIME) {
                        // Increase the failed attempt count
                        userService.increaseFailedAttempt(userDtls);
                    } else {
                        // Lock the user account after exceeding allowed attempts
                        userService.userAccountLock(userDtls);
                        exception = new LockedException("Your account is locked !! failed attempt 3");
                    }
                } else {
                    // Handle locked account scenario
                    if (userService.unlockAccountTimeExpired(userDtls)) {
                        exception = new LockedException("Your account is unlocked !! Please try to login");
                    } else {
                        exception = new LockedException("your account is Locked !! Please try after sometimes");
                    }
                }

            } else {
                // Handle inactive account scenario
                exception = new LockedException("your account is inactive");
            }
        } else {
            // Handle invalid email/password scenario
            exception = new LockedException("Email & password invalid");
        }

        // Redirect to the sign-in page with an error message
        super.setDefaultFailureUrl("/signin?error");
        super.onAuthenticationFailure(request, response, exception);
    }
}
