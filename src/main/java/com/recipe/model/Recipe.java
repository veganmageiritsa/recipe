package com.recipe.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nleontiou on 11/12/2018.
 */
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // save the property to child class (recipe)
    @OneToMany(cascade = CascadeType.ALL ,mappedBy="recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name="recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns =@JoinColumn(name = "category_id"))
    private Set<Category> categories;

}
