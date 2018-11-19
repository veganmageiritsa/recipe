package com.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nleontiou on 8/11/2018.
 */
@Controller
public class IndexController {

    @RequestMapping({"/",""})
    public String getIndexPage(){
        return "index";
    }


}
