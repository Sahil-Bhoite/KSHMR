package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Product;

/**
 * Service interface for managing product-related operations.
 * This interface defines methods for product CRUD operations and searches.
 * Project developed by Sahil and Maheshwari.
 */
public interface ProductService {

    /**
     * Saves a new product to the database.
     *
     * @param product the Product entity to be saved
     * @return the saved Product entity
     */
    public Product saveProduct(Product product);

    /**
     * Retrieves a list of all products in the system.
     *
     * @return a list of Product entities
     */
    public List<Product> getAllProducts();

    /**
     * Deletes a product based on the specified ID.
     *
     * @param id the ID of the product to be deleted
     * @return true if the product was successfully deleted, false otherwise
     */
    public Boolean deleteProduct(Integer id);

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to be retrieved
     * @return the Product entity associated with the specified ID
     */
    public Product getProductById(Integer id);

    /**
     * Updates an existing product, potentially including a new file.
     *
     * @param product the updated Product entity
     * @param file the MultipartFile associated with the product
     * @return the updated Product entity
     */
    public Product updateProduct(Product product, MultipartFile file);

    /**
     * Retrieves all active products for a specific category.
     *
     * @param category the category to filter active products
     * @return a list of active Product entities for the specified category
     */
    public List<Product> getAllActiveProducts(String category);

    /**
     * Searches for products based on a search string.
     *
     * @param ch the search string
     * @return a list of Product entities matching the search criteria
     */
    public List<Product> searchProduct(String ch);

    /**
     * Retrieves a paginated list of all active products.
     *
     * @param pageNo the page number to retrieve
     * @param pageSize the number of products per page
     * @param category the category to filter active products
     * @return a Page object containing active Product entities
     */
    public Page<Product> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category);

    /**
     * Searches for products and returns a paginated result.
     *
     * @param pageNo the page number to retrieve
     * @param pageSize the number of products per page
     * @param ch the search string
     * @return a Page object containing Product entities matching the search criteria
     */
    public Page<Product> searchProductPagination(Integer pageNo, Integer pageSize, String ch);

    /**
     * Retrieves a paginated list of all products.
     *
     * @param pageNo the page number to retrieve
     * @param pageSize the number of products per page
     * @return a Page object containing all Product entities
     */
    public Page<Product> getAllProductsPagination(Integer pageNo, Integer pageSize);

    /**
     * Searches for active products and returns a paginated result.
     *
     * @param pageNo the page number to retrieve
     * @param pageSize the number of products per page
     * @param category the category to filter products
     * @param ch the search string
     * @return a Page object containing active Product entities matching the search criteria
     */
    public Page<Product> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch);

}
