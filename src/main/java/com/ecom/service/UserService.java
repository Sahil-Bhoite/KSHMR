package com.ecom.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.UserDtls;

/**
 * Service interface for managing user-related operations.
 * This interface defines methods for user CRUD operations and account management.
 * Project developed by Sahil and Maheshwari.
 */
public interface UserService {

    /**
     * Saves a new user to the database.
     *
     * @param user the UserDtls entity to be saved
     * @return the saved UserDtls entity
     */
    public UserDtls saveUser(UserDtls user);

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user to be retrieved
     * @return the UserDtls entity associated with the specified email
     */
    public UserDtls getUserByEmail(String email);

    /**
     * Retrieves a list of users based on their role.
     *
     * @param role the role to filter users
     * @return a list of UserDtls entities with the specified role
     */
    public List<UserDtls> getUsers(String role);

    /**
     * Updates the account status of a user.
     *
     * @param id the ID of the user whose status will be updated
     * @param status the new status to set
     * @return true if the status was successfully updated, false otherwise
     */
    public Boolean updateAccountStatus(Integer id, Boolean status);

    /**
     * Increases the failed login attempt count for a user.
     *
     * @param user the UserDtls entity for which to increase failed attempts
     */
    public void increaseFailedAttempt(UserDtls user);

    /**
     * Locks the account of a user after too many failed attempts.
     *
     * @param user the UserDtls entity whose account will be locked
     */
    public void userAccountLock(UserDtls user);

    /**
     * Checks if the lock time for a user's account has expired.
     *
     * @param user the UserDtls entity to check
     * @return true if the lock time has expired, false otherwise
     */
    public boolean unlockAccountTimeExpired(UserDtls user);

    /**
     * Resets the failed login attempt count for a user.
     *
     * @param userId the ID of the user whose attempts will be reset
     */
    public void resetAttempt(int userId);

    /**
     * Updates the user's reset token for password recovery.
     *
     * @param email the email of the user
     * @param resetToken the reset token to be set
     */
    public void updateUserResetToken(String email, String resetToken);

    /**
     * Retrieves a user by their reset token.
     *
     * @param token the reset token of the user
     * @return the UserDtls entity associated with the specified token
     */
    public UserDtls getUserByToken(String token);

    /**
     * Updates an existing user's details.
     *
     * @param user the updated UserDtls entity
     * @return the updated UserDtls entity
     */
    public UserDtls updateUser(UserDtls user);

    /**
     * Updates a user's profile, including their profile image.
     *
     * @param user the UserDtls entity with updated profile information
     * @param img the MultipartFile associated with the user's new image
     * @return the updated UserDtls entity
     */
    public UserDtls updateUserProfile(UserDtls user, MultipartFile img);

    /**
     * Saves a new admin user to the database.
     *
     * @param user the UserDtls entity to be saved as an admin
     * @return the saved UserDtls entity
     */
    public UserDtls saveAdmin(UserDtls user);

    /**
     * Checks if an email already exists in the database.
     *
     * @param email the email to check
     * @return true if the email exists, false otherwise
     */
    public Boolean existsEmail(String email);

}
