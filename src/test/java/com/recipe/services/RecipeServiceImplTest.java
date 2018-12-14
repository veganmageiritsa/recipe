package com.recipe.services;

import com.recipe.model.Difficulty;
import com.recipe.model.Recipe;
import com.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by nleontiou on 14/12/2018.
 */
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception {

        Recipe recipe = Recipe.builder().id(1L).cookTime(5).description("lalala").difficulty(Difficulty.EASY).directions("Eat and Clean").build();
        Long id=1L;
        HashSet<Recipe> recipesData=new HashSet<>();
        recipesData.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1L);
        assertEquals(recipe.getId(),id);
        verify(recipeRepository,times(1) ).findAll();
    }

}