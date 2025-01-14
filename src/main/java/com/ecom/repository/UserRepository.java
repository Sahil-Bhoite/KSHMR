package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.UserDtls;

/**
 * Repository interface for managing UserDtls entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 * Project developed by Sahil and Maheshwari.
 */
public interface UserRepository extends JpaRepository<UserDtls, Integer> {

    /**
     * Finds a UserDtls entity by its email.
     *
     * @param email the email of the user to find
     * @return the UserDtls entity associated with the given email
     */
    public UserDtls findByEmail(String email);

    /**
     * Finds a list of UserDtls entities by their role.
     *
     * @param role the role of users to find
     * @return a list of UserDtls entities with the specified role
     */
    public List<UserDtls> findByRole(String role);

    /**
     * Finds a UserDtls entity by its reset token.
     *
     * @param token the reset token of the user to find
     * @return the UserDtls entity associated with the given reset token
     */
    public UserDtls findByResetToken(String token);

    /**
     * Checks if a user exists by their email.
     *
     * @param email the email to check
     * @return true if a user exists with the specified email, false otherwise
     */
    public Boolean existsByEmail(String email);
}
