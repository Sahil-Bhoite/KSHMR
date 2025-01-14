package com.ecom.service;

import java.util.List;

import com.ecom.model.Cart;

/**
 * Service interface for managing Cart operations.
 * Contains methods for cart-related functionalities.
 * Project developed by Sahil and Maheshwari.
 */
public interface CartService {

    /**
     * Saves a cart entry for a specified product and user.
     *
     * @param productId the ID of the product to be added to the cart
     * @param userId the ID of the user who owns the cart
     * @return the created Cart entity
     */
    public Cart saveCart(Integer productId, Integer userId);

    /**
     * Retrieves a list of carts for a specified user.
     *
     * @param userId the ID of the user whose carts are to be retrieved
     * @return a list of Cart entities associated with the specified user
     */
    public List<Cart> getCartsByUser(Integer userId);
    
    /**
     * Gets the total count of items in the cart for a specified user.
     *
     * @param userId the ID of the user whose cart count is to be retrieved
     * @return the total number of items in the cart for the specified user
     */
    public Integer getCountCart(Integer userId);

    /**
     * Updates the quantity of a specific cart item.
     *
     * @param sy the new quantity to set
     * @param cid the ID of the cart item to be updated
     */
    public void updateQuantity(String sy, Integer cid);
}
