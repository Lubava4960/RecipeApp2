package com.example.recipeapp2.model;

import java.util.List;

public class Ingredient {
    private String title;
    private int number;
    private String measure;
    private List<Ingredient> ingredients;

    public Ingredient(String title, int number, String measure, List<Ingredient> ingredients) {
        this.title = title;
        this.number = number;
        this.measure = measure;
        this.ingredients = ingredients;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}




