package com.recipe.controllers;

import com.recipe.model.Difficulty;
import com.recipe.model.Recipe;
import com.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by nleontiou on 14/12/2018.
 */
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void testMovkMvc() throws Exception{
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    @Test
    public void getIndexPage() throws Exception {
        //given
        Set<Recipe> recipes=new HashSet<>();
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .cookTime(5)
                .description("lalala")
                .difficulty(Difficulty.EASY)
                .directions("Eat and Clean").build();
        Recipe recipe2 = Recipe.builder().id(2L).cookTime(8).description("ltearla").difficulty(Difficulty.MODERATE).directions("Eat and Clean").build();
        recipes.add(recipe1);recipes.add(recipe2);
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);

        String viewName=indexController.getIndexPage(model);
        assertEquals(viewName,"index");
        verify(recipeService,times(1) ).getRecipes();
        verify(model,times(1) ).addAttribute(eq("recipes"),anySet());

//        Set<Recipe> setinController=argumentCaptor.getValue();
//        assertEquals(2L,setinController.size());
    }


}