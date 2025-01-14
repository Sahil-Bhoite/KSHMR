package com.ecom.model;

import lombok.Data;
import lombok.ToString;

/**
 * Model class representing an order request.
 * This class is used to capture the details of an order placed by a customer.
 * Project developed by Sahil and Maheshwari.
 */
@ToString
@Data
public class OrderRequest {

    private String firstName; // Customer's first name

    private String lastName;  // Customer's last name

    private String email;     // Customer's email address

    private String mobileNo;  // Customer's mobile number

    private String address;   // Customer's shipping address

    private String city;      // City for the delivery

    private String state;     // State for the delivery

    private String pincode;   // Pincode for the delivery area
    
    private String paymentType; // Type of payment (e.g., credit card, PayPal)

}
