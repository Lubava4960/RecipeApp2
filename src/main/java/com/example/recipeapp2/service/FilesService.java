package com.example.recipeapp2.service;

import com.example.recipeapp2.model.Ingredient;

import com.example.recipeapp2.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface FilesService {


    void cleanDataFile();


    boolean saveToFileRecipes(String json);

    String readFromFile() throws IOException;
    void saveToFileIngredients(String json, Map<Integer, Ingredient> ingredients);
    void saveToFileRecipes(String json, Map<Integer, Recipe> recipes);


    void cleanIngredientFile();

    File getRecipeFile();


    File getIngredientFile();

    File getRecipeFile(String json);

    Path greatTempFile(String suffix);

    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();



}
