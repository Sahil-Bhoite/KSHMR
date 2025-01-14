package com.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents the address details for an order in the KSHMR project.
 * This class is part of the backend model layer and is used to store
 * order address information in the database.
 * Project developed by Sahil and Maheshwari.
 */
@Data
@Entity
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Unique identifier for the order address

    private String firstName; // First name of the recipient

    private String lastName; // Last name of the recipient

    private String email; // Email address of the recipient

    private String mobileNo; // Mobile number of the recipient

    private String address; // Detailed address of the recipient

    private String city; // City of the recipient

    private String state; // State of the recipient

    private String pincode; // Pincode of the recipient's address
}
