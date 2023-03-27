package com.example.recipeapp2.dto;

import com.example.recipeapp2.service.Ingredient;

import java.util.List;
public class IngredientDTO {

    private final int id;
    private final String title;
    private final int number;

    private final String measure;
    private static List<Ingredient> ingredients;

    public IngredientDTO(int id, String title, int number, String measure) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.measure = measure;

    }

    public List<Ingredient> getIngredients() {

        return ingredients;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getMeasure() {
        return measure;
    }

    public static IngredientDTO from(int id, Ingredient ingredient){
        return new IngredientDTO (id, ingredient.getTitle(), ingredient.getNumber(), ingredient.getMeasure());

    }






}

