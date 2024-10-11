package com.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a product category in the KSHMR project.
 * This class is mapped to the database as a JPA entity.
 * Project developed by Sahil.
 */
@AllArgsConstructor
@NoArgsConstructor // No-argument constructor for JPA
@Getter // Getter methods for all fields
@Setter // Setter methods for all fields
@Entity // Indicates that this class is a JPA entity
public class Category {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Integer id; // Unique identifier for the category

    private String name; // Name of the category

    private String imageName; // Image associated with the category

    private Boolean isActive; // Indicates whether the category is active or not

}
