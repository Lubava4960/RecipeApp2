package com.example.recipeapp2.service;

import com.example.recipeapp2.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface FilesService {


    boolean cleanDataFile();

    boolean saveToFileRecipes(String json);

    String readFromFile() throws IOException;

    void saveToFileIngredients(String json, Map<Integer, Ingredient> ingredients);

    void saveToFileRecipes(String json, Map<Integer, Recipe> recipes);


    boolean cleanIngredientFile();

    File getDataFile();

    File getDataFile(String json);

    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();
}
