package com.example.recipeapp2.service;

import com.example.recipeapp2.model.Ingredient;

import com.example.recipeapp2.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface FilesService {


    void cleanDataFile();

    boolean  saveToFileRecipes(String json);

    String readFromFile() throws IOException;
    void saveToFileIngredients(String json, Map<Integer, Ingredient> ingredients);
    void saveToFileRecipes(String json, Map<Integer, Recipe> recipes);


    void cleanIngredientFile();

    File getRecipeFile();

    File getIngredientFile();

    File getRecipeFile(String json);

    // todo: надо реализовать
    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();


}
