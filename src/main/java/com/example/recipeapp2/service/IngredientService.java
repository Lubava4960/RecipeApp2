package com.example.recipeapp2.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService {
    private static final String STORE_FILE_NAME = "ingredients";
    public FilesService filesService;
    private int idCounter = 0;
    static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    public IngredientService(FilesService filesService) {
        this.filesService = filesService;

    }
    public static IngredientDTO updateIngredient(int id, Ingredient ingredient) {
        Ingredient existingIngredient = ingredient.getIngredient(id);
        if(existingIngredient==null){
            throw new IngredientNotFoundException();
        }
        ingredient.put(id, ingredient);
        FilesService.saveToFile(STORE_FILE_NAME, ingredients);
        return IngredientDTO.from(id, ingredient);
    }


    public IngredientDTO addIngredient(Ingredient ingredient){
        int id = idCounter++;
        ingredient.put(id, ingredient);
        FilesService.saveToFile(STORE_FILE_NAME, ingredients);
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
        FilesService.saveToFile(STORE_FILE_NAME, ingredients);
        if (existingIngredient==null){
            throw new ingredientNotFoundException();
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












    // @PostConstruct
    //private void init() throws IOException {
    //     readFromFileIngredient();
    // }
}

