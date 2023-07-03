package com.example.recipeapp2.service;

import com.example.recipeapp2.model.Ingredient;
import com.example.recipeapp2.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Map;

public interface FilesService {


    void cleanDataFile();

    String readFromFile() throws IOException;

    void saveToFileIngredients(String json, Map<Integer, Ingredient> ingredients);

    void saveToFileRecipes(String json, Map<Integer, Recipe> recipes);


    void saveToFileRecipes(String json);


    void cleanIngredientFile();

    File getRecipeFile();


    File getDataFile();

    File getIngredientFile();


    File getRecipeFile(String json);

    Path greatTempFile(String suffix);


    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();


    void exportFromMemory(PrintWriter writer);
}