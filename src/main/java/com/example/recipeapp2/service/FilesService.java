package com.example.recipeapp2.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface FilesService {


    boolean cleanDataFile();

    String readFromFile() throws IOException;

    static void saveToFile(String json, Map<Integer, Ingredient> ingredients) {
    }
    boolean cleanIngredientFile();

    File getDataFile();


}
