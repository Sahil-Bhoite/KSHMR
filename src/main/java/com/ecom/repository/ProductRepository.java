package com.ecom.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Product;

/**
 * Repository interface for managing Product entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 * Project developed by Sahil and Maheshwari.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Finds all active products.
     *
     * @return a list of active Product entities
     */
    List<Product> findByIsActiveTrue();

    /**
     * Finds all active products with pagination support.
     *
     * @param pageable pagination information
     * @return a paginated list of active Product entities
     */
    Page<Product> findByIsActiveTrue(Pageable pageable);

    /**
     * Finds products by category.
     *
     * @param category the category of products to find
     * @return a list of Product entities in the specified category
     */
    List<Product> findByCategory(String category);

    /**
     * Finds products by title or category, ignoring case.
     *
     * @param ch the substring to search in the title
     * @param ch2 the substring to search in the category
     * @return a list of Product entities matching the search criteria
     */
    List<Product> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2);

    /**
     * Finds products by category with pagination support.
     *
     * @param pageable pagination information
     * @param category the category of products to find
     * @return a paginated list of Product entities in the specified category
     */
    Page<Product> findByCategory(Pageable pageable, String category);

    /**
     * Finds products by title or category with pagination, ignoring case.
     *
     * @param ch the substring to search in the title
     * @param ch2 the substring to search in the category
     * @param pageable pagination information
     * @return a paginated list of Product entities matching the search criteria
     */
    Page<Product> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
            Pageable pageable);

    /**
     * Finds active products by title or category with pagination, ignoring case.
     *
     * @param ch the substring to search in the title
     * @param ch2 the substring to search in the category
     * @param pageable pagination information
     * @return a paginated list of active Product entities matching the search criteria
     */
    Page<Product> findByisActiveTrueAndTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
            Pageable pageable);
}
