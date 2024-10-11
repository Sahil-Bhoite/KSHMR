package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.ProductOrder;

/**
 * Repository interface for managing ProductOrder entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 * Project developed by Sahil and Maheshwari.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    /**
     * Finds a list of ProductOrder by the user ID.
     *
     * @param userId the ID of the user for whom to find orders
     * @return a list of ProductOrder associated with the given user ID
     */
    List<ProductOrder> findByUserId(Integer userId);

    /**
     * Finds a ProductOrder by its order ID.
     *
     * @param orderId the ID of the order to find
     * @return the ProductOrder with the specified order ID
     */
    ProductOrder findByOrderId(String orderId);
}
