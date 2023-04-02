package com.example.recipeapp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recipe {

    private String title;
    private  int cookingTime;
    private  List<Ingredient> ingredients;
    private  List<String> steps;


}
