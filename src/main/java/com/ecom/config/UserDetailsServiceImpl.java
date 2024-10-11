package com.ecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;

/**
 * Implementation of UserDetailsService for loading user-specific data.
 * Retrieves user information from the database based on the username (email).
 * Project developed by Sahil.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Repository for accessing user data

    /**
     * Loads user details by username (email).
     *
     * @param username the username (email) used for authentication
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Retrieve the user details from the repository
        UserDtls user = userRepository.findByEmail(username);

        // If user is not found, throw an exception
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        // Return a CustomUser object containing the user details
        return new CustomUser(user);
    }

}
