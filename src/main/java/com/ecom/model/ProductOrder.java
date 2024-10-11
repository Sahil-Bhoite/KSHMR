package com.ecom.model;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a product order in the KSHMR application.
 * This entity contains order details such as product, user, and payment information.
 * Project developed by Sahil and Maheshwari.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Unique identifier for the order

    private String orderId; // Unique order identifier

    private LocalDate orderDate; // Date when the order was placed

    @ManyToOne
    private Product product; // Product associated with this order

    private Double price; // Total price of the order

    private Integer quantity; // Quantity of the product ordered

    @ManyToOne
    private UserDtls user; // User who placed the order

    private String status; // Status of the order (e.g., pending, completed)

    private String paymentType; // Type of payment used (e.g., credit card, PayPal)

    @OneToOne(cascade = CascadeType.ALL)
    private OrderAddress orderAddress; // Shipping address for the order
}
