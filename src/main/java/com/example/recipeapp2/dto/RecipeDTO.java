package com.example.recipeapp2.dto;

import com.example.recipeapp2.model.Recipe;
import com.example.recipeapp2.model.Ingredient;

import java.util.List;

public record RecipeDTO(int id, String title, int cookingTime, List<Ingredient> ingredients, List<String> steps) {


    public static RecipeDTO from(Integer id, Recipe recipe) {
        return new RecipeDTO(id, recipe.getTitle(), recipe.getCookingTime(), recipe.getIngredients(),
                recipe.getSteps());


    }



    }

