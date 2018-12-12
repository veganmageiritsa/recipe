package com.recipe.services;

import com.recipe.model.Recipe;

import java.util.Set;

/**
 * Created by nleontiou on 12/12/2018.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
