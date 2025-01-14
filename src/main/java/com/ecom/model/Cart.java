package com.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a shopping cart entity in the e-commerce application.
 * This class maps to the 'Cart' table in the database.
 * Project developed by Sahil as part of the KSHMR project for a hackathon.
 */
@Entity
@AllArgsConstructor // Lombok annotation to generate a constructor with all parameters
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor
@Getter // Lombok annotation to generate getter methods for all fields
@Setter // Lombok annotation to generate setter methods for all fields
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates unique IDs
    private Integer id; // Unique identifier for the cart item

    @ManyToOne // Many cart items can belong to one user
    private UserDtls user; // The user associated with this cart

    @ManyToOne // Many cart items can refer to one product
    private Product product; // The product associated with this cart item

    private Integer quantity; // Quantity of the product in the cart

    @Transient // This field is not stored in the database
    private Double totalPrice; // Total price for this cart item (calculated field)

    @Transient // This field is not stored in the database
    private Double totalOrderPrice; // Total price for the entire order (calculated field)
}
