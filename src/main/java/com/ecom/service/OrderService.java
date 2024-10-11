package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecom.model.OrderRequest;
import com.ecom.model.ProductOrder;

/**
 * Service interface for managing order-related operations.
 * Contains methods for order processing and retrieval.
 * Project developed by Sahil and Maheshwari.
 */
public interface OrderService {

    /**
     * Saves a new order based on the provided user ID and order request.
     *
     * @param userid the ID of the user placing the order
     * @param orderRequest the details of the order to be saved
     * @throws Exception if there is an error while saving the order
     */
    public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

    /**
     * Retrieves a list of orders associated with a specific user.
     *
     * @param userId the ID of the user whose orders are to be retrieved
     * @return a list of ProductOrder entities for the specified user
     */
    public List<ProductOrder> getOrdersByUser(Integer userId);

    /**
     * Updates the status of an existing order.
     *
     * @param id the ID of the order to be updated
     * @param status the new status to set for the order
     * @return the updated ProductOrder entity
     */
    public ProductOrder updateOrderStatus(Integer id, String status);

    /**
     * Retrieves a list of all orders in the system.
     *
     * @return a list of all ProductOrder entities
     */
    public List<ProductOrder> getAllOrders();

    /**
     * Retrieves an order by its order ID.
     *
     * @param orderId the ID of the order to be retrieved
     * @return the ProductOrder entity associated with the specified order ID
     */
    public ProductOrder getOrdersByOrderId(String orderId);
    
    /**
     * Retrieves a paginated list of all orders.
     *
     * @param pageNo the number of the page to retrieve
     * @param pageSize the number of orders per page
     * @return a Page object containing ProductOrder entities
     */
    public Page<ProductOrder> getAllOrdersPagination(Integer pageNo, Integer pageSize);
}
