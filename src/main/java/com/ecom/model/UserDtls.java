package com.ecom.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserDtls class representing the user entity in the database.
 * Contains user-specific information and is mapped to the 'User' table.
 * Project: Kashmir's Specialties Handicrafts & Merchandise Retails (KSHMR)
 * Developed by Sahil and Maheshwari.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    private Integer id;

    private String name; // User's full name

    private String mobileNumber; // User's mobile number

    private String email; // User's email address

    private String address; // User's address

    private String city; // User's city

    private String state; // User's state

    private String pincode; // User's postal code

    private String password; // User's password (hashed)

    private String profileImage; // URL or path to user's profile image

    private String role; // User's role (e.g., ADMIN, USER)

    private Boolean isEnable; // Indicates if the user account is enabled

    private Boolean accountNonLocked; // Indicates if the user account is locked

    private Integer failedAttempt; // Count of failed login attempts

    private Date lockTime; // Timestamp for when the account was locked

    private String resetToken; // Token for password reset
}
