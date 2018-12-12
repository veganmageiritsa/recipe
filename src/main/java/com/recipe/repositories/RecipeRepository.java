package com.recipe.repositories;

import com.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nleontiou on 11/12/2018.
 */

public interface RecipeRepository extends CrudRepository<Recipe,Long>{


}
