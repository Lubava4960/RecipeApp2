package com.example.recipeapp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient{
    private String title;
    private int number;
    private String measure;
    private List<Ingredient> ingredients;

}




