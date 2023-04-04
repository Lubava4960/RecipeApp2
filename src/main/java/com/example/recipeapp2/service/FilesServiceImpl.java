package com.example.recipeapp2.service;

import com.example.recipeapp2.model.Ingredient;
import com.example.recipeapp2.model.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public  class FilesServiceImpl implements FilesService {


    @Value("${path.to.data.file}")
    private String dataFilePath;


    @Value("${name.of.data.file}")
    private String dataFileName;


    @Value("${path.to.ingredient.file}")
    private String ingredientFilePath;

    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;

    @Override
    public void cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToFileRecipes(String json, Map<Integer, Recipe> recipes) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   @Override
    public String readFromFile(){
        try{
            return Files.readString(Path.of(dataFilePath,dataFileName));//чтение
        }catch(IOException e){
            throw new RuntimeException(e);

        }

    }

    @Override
    public void saveToFileIngredients(String json, Map<Integer, Ingredient> ingredients) {
        try {
            cleanIngredientFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveToFileRecipes(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cleanIngredientFile() {
        try {
            Path path = Path.of(ingredientFilePath, ingredientFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File getRecipeFile() {
        return null;
    }

    @Override
    public File getDataFile() {
        return Path.of(dataFilePath, dataFileName).toFile();
    }

    @Override
    public File getIngredientFile() {
        return new File(ingredientFilePath+"/"+ingredientFileName);
    }

    @Override
    public File getRecipeFile(String json) {
        return null;
    }


    @Override
   public Path greatTempFile(String suffix){
        try{
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        }catch (IOException e){
            throw new RuntimeException(e);
       }
   }

    @Override
    public boolean saveToIngredientFile(String json) {
        try {
            cleanIngredientFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readFromIngredientFile() {
        try {
            return Files.readString(Path.of(ingredientFilePath, ingredientFileName));//чтение
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    }




