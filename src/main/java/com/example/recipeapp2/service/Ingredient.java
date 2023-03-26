package com.example.recipeapp2.service;

import com.example.recipeapp2.dto.IngredientDTO;

public record Ingredient(String title, int number, String measure) {


    public void put(int id, Ingredient ingredient) {
        IngredientDTO.from(id, ingredient);
    }

    public IngredientDTO get(int id) {

        return null;
    }

    // public static IngredientDTO get(int id) {
   //     Ingredient ingredient = Ingredient.get(id);
   //     if (ingredient != null) {
    //        return IngredientDTO.from(id, ingredient);
    //    }
    //    return null;
    //}


    }




