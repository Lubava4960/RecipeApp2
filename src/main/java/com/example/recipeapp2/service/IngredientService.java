package com.example.recipeapp2.service;

import com.example.recipeapp2.dto.IngredientDTO;
import com.example.recipeapp2.model.Ingredient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class IngredientService {

    private final String STORE_FILE_NAME = "json";
    private final FilesService filesService;
    private int idCounter = 0;
    private  static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    private String ingredientFilePath;
    private String ingredientFileName;

        public IngredientService(FilesService filesService) {
        this.filesService = filesService;

    }

        public void cleanIngredientFile() {
        try {
            Path path = Path.of(ingredientFilePath, ingredientFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public IngredientDTO updateIngredient(int id, Ingredient ingredient) {
        Ingredient existingIngredient = ingredients.get(id);
               if (existingIngredient == null) {
            throw new IngredientNotFoundException();
        }
        ingredients.put(id, ingredient);
        return IngredientDTO.from(id, ingredient);
    }

        public IngredientDTO addIngredient(Ingredient ingredient) {
        int id = idCounter++;
        ingredients.put(id, ingredient);
        filesService.saveToFileIngredients(STORE_FILE_NAME, ingredients);
        return IngredientDTO.from(id, ingredient);
    }

        public IngredientDTO getIngredient(int id) {
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null) {
            return IngredientDTO.from(id, ingredient);
        }else {
            return null;
        }

    }

        public IngredientDTO deleteById(int id) {
        Ingredient existingIngredient = ingredients.remove(id);
        filesService.saveToFileIngredients(STORE_FILE_NAME, ingredients);
        if (existingIngredient == null) {
            throw new IngredientNotFoundException();
        }
        return IngredientDTO.from(id, existingIngredient);
    }


        public List<IngredientDTO> getAllIngredients() {
        List<IngredientDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()) {
            result.add(IngredientDTO.from(entry.getKey(), entry.getValue()));
        }
        return result;

    }

        private void readFromFileIngredient () {
            String json = filesService.readFromIngredientFile();
            try {
                new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
                });
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        public File getIngredientFile() {
        return Path.of(ingredientFilePath, ingredientFileName).toFile();
        }

        @PostConstruct
        private void init () {

        readFromFileIngredient();
        }



}





