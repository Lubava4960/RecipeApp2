package com.example.recipeapp2.dto;

import com.example.recipeapp2.model.Ingredient;

public  record IngredientDTO (int id,String title, int number, String measure){


    public static IngredientDTO from(int id, Ingredient ingredient){
        return new IngredientDTO (id, ingredient.getTitle(), ingredient.getNumber(), ingredient.getMeasure());

    }






}

