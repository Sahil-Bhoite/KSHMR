package com.ecom.util;

/**
 * Enum representing various order statuses in the e-commerce application.
 * Project: Kashmir's Specialties Handicrafts & Merchandise Retails (KSHMR)
 * Developed by Sahil and Maheshwari.
 */
public enum OrderStatus {

    IN_PROGRESS(1, "In Progress"), 
    ORDER_RECEIVED(2, "Order Received"), 
    PRODUCT_PACKED(3, "Product Packed"),
    OUT_FOR_DELIVERY(4, "Out for Delivery"), 
    DELIVERED(5, "Delivered"),
    CANCEL(6, "Cancelled"),
    SUCCESS(7, "Success");

    private Integer id; // Unique identifier for the order status
    private String name; // Human-readable name of the order status

    /**
     * Constructor to initialize the enum constants with id and name.
     *
     * @param id the unique identifier for the order status
     * @param name the human-readable name of the order status
     */
    private OrderStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the unique identifier of the order status.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the order status (not typically used for enums).
     *
     * @param id the unique identifier to set
     */
    public void setId(Integer id) {
        this.id = id; // This method is not typically used in enums, as they are constant.
    }

    /**
     * Gets the human-readable name of the order status.
     *
     * @return the name of the order status
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the human-readable name of the order status (not typically used for enums).
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name; // This method is not typically used in enums, as they are constant.
    }
}
