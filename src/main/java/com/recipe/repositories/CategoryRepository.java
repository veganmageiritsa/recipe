package com.recipe.repositories;

import com.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nleontiou on 11/12/2018.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
