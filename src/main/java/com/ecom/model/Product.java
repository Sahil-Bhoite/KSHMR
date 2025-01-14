package com.ecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a Product in the KSHMR application.
 * This class is part of the backend model for the project developed by Sahil and Maheshwari.
 */
@AllArgsConstructor // Generates a constructor with all parameters
@NoArgsConstructor // Generates a no-argument constructor
@Getter // Generates getter methods for all fields
@Setter // Generates setter methods for all fields
@Entity // Indicates that this class is a JPA entity
public class Product {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key should be generated
    private Integer id; // Unique identifier for the product

    @Column(length = 500) // Specifies the length of the column in the database
    private String title; // Title of the product

    @Column(length = 5000) // Specifies the length of the description column
    private String description; // Detailed description of the product

    private String category; // Category to which the product belongs

    private Double price; // Price of the product

    private int stock; // Quantity of the product in stock

    private String image; // URL or path to the product image

    private int discount; // Discount percentage on the product

    private Double discountPrice; // Price after discount

    private Boolean isActive; // Indicates whether the product is active for sale
}
