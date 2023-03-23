package com.example.recipeapp2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    public FilesService filesService;

    private int idCounter = 0;
    private static final Map<Integer, Recipe> recipes = new HashMap<>();
    private Map<Integer, Ingredient> Recipe;

    public RecipeService(FilesService filesService) {

        this.filesService = filesService;
    }

    public RecipeDTO addRecipe(Recipe recipe) {
        int id = idCounter++;
        recipes.put(id, recipe);
        saveToFile();
        return RecipeDTO.from(id, recipe);
    }


    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> entry : recipes.entrySet()) {
            result.add(RecipeDTO.from(entry.getKey(), entry.getValue()));
        }
        saveToFile();
        return result;
    }

    public static RecipeDTO updateRecipe(int id, Recipe recipe) {
        Recipe existingRecipe = recipes.get(id);
        if (existingRecipe == null) {
            throw new RecipeNotFoundException();
        }
        recipes.put(id, recipe);
        return RecipeDTO.from(id, recipe);
    }

    public RecipeDTO deleteDyId(Integer id) {
        Recipe existingRecipe = recipes.remove(id);
        if (existingRecipe == null) {
            throw new RecipeNotFoundException();
        }
        return RecipeDTO.from(id, existingRecipe);
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return RecipeDTO.from(id, recipe);
        }
        return null;
    }

    private boolean saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            FilesService.saveToFile(json, Recipe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    private void readFromFile() throws IOException {
        String json = filesService.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @PostConstruct
    private void init() throws IOException {
        readFromFile();
    }



}
