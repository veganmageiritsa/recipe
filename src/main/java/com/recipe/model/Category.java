package com.recipe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nleontiou on 11/12/2018.
 */

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String description;
    @ManyToMany (mappedBy = "categories")
    private Set<Recipe> recipes;

}
