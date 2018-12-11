package com.recipe.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by nleontiou on 11/12/2018.
 */
@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ingredientId;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    UnitOfMeasure uom;


}
