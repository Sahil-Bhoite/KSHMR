package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecom.model.Category;

/**
 * Service interface for managing Category operations.
 * Contains methods for category-related functionalities.
 * Project developed by Sahil and Maheshwari.
 */
public interface CategoryService {

    /**
     * Saves a new category.
     *
     * @param category the Category entity to be saved
     * @return the saved Category entity
     */
    public Category saveCategory(Category category);

    /**
     * Checks if a category exists by its name.
     *
     * @param name the name of the category to check
     * @return true if the category exists, false otherwise
     */
    public Boolean existCategory(String name);

    /**
     * Retrieves a list of all categories.
     *
     * @return a list of all Category entities
     */
    public List<Category> getAllCategory();

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to be deleted
     * @return true if the category was successfully deleted, false otherwise
     */
    public Boolean deleteCategory(int id);

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to be retrieved
     * @return the Category entity associated with the specified ID
     */
    public Category getCategoryById(int id);

    /**
     * Retrieves a list of all active categories.
     *
     * @return a list of active Category entities
     */
    public List<Category> getAllActiveCategory();

    /**
     * Retrieves a paginated list of categories.
     *
     * @param pageNo the number of the page to retrieve
     * @param pageSize the number of categories per page
     * @return a Page object containing Category entities
     */
    public Page<Category> getAllCategorPagination(Integer pageNo, Integer pageSize);
}
