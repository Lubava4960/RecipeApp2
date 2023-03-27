package com.example.recipeapp2.service;

import com.example.recipeapp2.dto.IngredientDTO;
import com.example.recipeapp2.model.Ingredient;
import com.example.recipeapp2.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
public class IngredientService {
        private static final String STORE_FILE_NAME = "ingredients";
        private FilesService filesService;
        private int idCounter = 0;
        private static final Map<Integer, Ingredient> ingredients = new HashMap<>();

        public IngredientService(FilesService filesService) {
            this.filesService = filesService;

        }
        public IngredientDTO updateIngredient(int id, Ingredient ingredient) {
            Ingredient existingIngredient = ingredients.get(id);
            if(existingIngredient==null){
                throw new IngredientNotFoundException();
            }
            ingredients.put(id, ingredient);
            filesService.saveToFileIngredients(STORE_FILE_NAME, ingredients);
            return IngredientDTO.from(id, ingredient);
        }


        public IngredientDTO addIngredient(Ingredient ingredient){
            int id = idCounter++;
            ingredients.put(id, ingredient);
            filesService.saveToFileIngredients(STORE_FILE_NAME, ingredients);
            return IngredientDTO.from(id, ingredient);
        }

        public static IngredientDTO getIngredient(int id){
            Ingredient ingredient = ingredients.get(id);
            if (ingredient != null){
                return IngredientDTO.from(id, ingredient);
            }
            return null;
        }

        public IngredientDTO deleteById(int id) {
            Ingredient existingIngredient=ingredients.remove(id);
            filesService.saveToFileIngredients(STORE_FILE_NAME, ingredients);
            if (existingIngredient==null){
                throw new IngredientNotFoundException();
            }
            return IngredientDTO.from(id, existingIngredient);
        }


        public List<IngredientDTO> getAllIngredients() {
            List<IngredientDTO> result = new ArrayList<>();
            for (Map.Entry<Integer,Ingredient>entry:ingredients.entrySet()){
                result.add(IngredientDTO.from(entry.getKey(), entry.getValue()));
            }
            return result;
        }

       private boolean saveToFile(String storeFileName, Map<Integer, Ingredient> ingredients){
         try {
            String json = new ObjectMapper().writeValueAsString(IngredientService.ingredients);
            filesService.saveToFileIngredients(json, ingredients);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void readFromFile() throws IOException {
        String json = filesService.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
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

