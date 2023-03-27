package com.example.recipeapp2.service;

import com.example.recipeapp2.dto.IngredientDTO;

import java.util.List;


public record Ingredient(String title, int number, String measure) {

    private static List<Ingredient> ingredients;


    public void put(int id, Ingredient ingredient) {

      IngredientDTO.from(id, (IngredientDTO) ingredients);
    }


    public static IngredientDTO get(int id) {
        IngredientDTO ingredient = Ingredient.get(id);
        if (ingredient != null) {
            return IngredientDTO.from( id,  ingredient);
        }
        return null;
    }

}




