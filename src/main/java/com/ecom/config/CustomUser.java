package com.ecom.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecom.model.UserDtls;

/**
 * Custom implementation of UserDetails to integrate user information
 * into Spring Security's authentication system.
 * Project developed by Sahil.
 */
public class CustomUser implements UserDetails {

    private UserDtls user; // User details model

    public CustomUser(UserDtls user) {
        super();
        this.user = user; // Initialize with user details
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Create a SimpleGrantedAuthority based on the user's role
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(authority); // Return as a list
    }

    /**
     * Returns the user's password.
     *
     * @return the user's password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username (email) of the user.
     *
     * @return the user's email
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the user's account is expired.
     *
     * @return true if the account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Account is not expired
    }

    /**
     * Indicates whether the user's account is locked.
     *
     * @return true if the account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNonLocked(); // Check if account is not locked
    }

    /**
     * Indicates whether the user's credentials are expired.
     *
     * @return true if credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credentials are not expired
    }

    /**
     * Indicates whether the user is enabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return user.getIsEnable(); // Check if user is enabled
    }

}
