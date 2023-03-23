package com.example.recipeapp2.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class Recipe {
    public int getCookingTime;
    private String title;
    private int cookingTime;
    private List<ingredient> ingredients;
    private List<String> steps;

    public Recipe(String title, int cookingTime, List<ingredient> ingredients, List<String> steps) {
        this.title = title;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
