package com.example.recipeapp2.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface FilesService {


    boolean cleanDataFile();

    boolean saveToFile(String json);

    String readFromFile() throws IOException;

  void saveToFile(String json, Map<Integer, Ingredient> ingredients);


    boolean cleanIngredientFile();

    File getDataFile();

    boolean saveToIngredientFile(String json);

    String readFromIngredientFile();
}
