package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Category;

/**
 * Repository interface for managing Category entities.
 * Extends JpaRepository to provide CRUD operations for Category.
 * Project developed by Sahil and Maheshwari.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Checks if a Category with the specified name exists.
     *
     * @param name the name of the Category to check
     * @return true if a Category with the given name exists, false otherwise
     */
    public Boolean existsByName(String name);

    /**
     * Retrieves a list of active Categories.
     *
     * @return a List of active Category entities
     */
    public List<Category> findByIsActiveTrue();

}
