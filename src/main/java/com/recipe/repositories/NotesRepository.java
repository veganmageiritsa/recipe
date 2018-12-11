package com.recipe.repositories;

import com.recipe.model.Notes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nleontiou on 11/12/2018.
 */
public interface NotesRepository extends CrudRepository<Notes,Long> {
}
