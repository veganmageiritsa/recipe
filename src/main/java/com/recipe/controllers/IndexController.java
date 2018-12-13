package com.recipe.controllers;

import com.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nleontiou on 8/11/2018.
 */
@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/",""})
    public String getIndexPage(Model model){
        log.debug("Index Page");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }


}
