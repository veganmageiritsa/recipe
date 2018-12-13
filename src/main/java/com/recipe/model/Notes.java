package com.recipe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by nleontiou on 11/12/2018.
 */

@Data
@EqualsAndHashCode(exclude = "recipe")

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
