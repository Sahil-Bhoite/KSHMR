package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Cart;

/**
 * Repository interface for managing Cart entities.
 * Extends JpaRepository to provide CRUD operations and custom queries.
 * Project developed by Sahil and Maheshwari.
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {

    /**
     * Finds a Cart by its product ID and user ID.
     *
     * @param productId the ID of the product
     * @param userId    the ID of the user
     * @return the Cart associated with the specified product and user
     */
    public Cart findByProductIdAndUserId(Integer productId, Integer userId);

    /**
     * Counts the number of Cart items for a specific user.
     *
     * @param userId the ID of the user
     * @return the number of Cart items for the user
     */
    public Integer countByUserId(Integer userId);

    /**
     * Finds all Cart items for a specific user.
     *
     * @param userId the ID of the user
     * @return a list of Cart items associated with the user
     */
    public List<Cart> findByUserId(Integer userId);

}
