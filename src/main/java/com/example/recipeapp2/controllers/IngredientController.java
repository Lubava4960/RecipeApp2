package com.example.recipeapp2.controllers;

import com.example.recipeapp2.dto.IngredientDTO;
import com.example.recipeapp2.service.Ingredient;
import com.example.recipeapp2.service.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/ingredient")

@Tag(name = "Ингредиенты", description = "CRUD-оперцации и  другие эдпоинды для работы с ингредиентами")

public class IngredientController {
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {

        this.ingredientService = ingredientService;
    }

    @GetMapping
    @Operation (
            description = "получения всех ингредиентов"
    )
    public List<IngredientDTO> getIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "получение ингредиента",
            description = " Можно получить по id"
    )
    public IngredientDTO getIngredient(@PathVariable("id") int id){

        return IngredientService.getIngredient(id);
    }

    @PostMapping
    @Operation(
            description = "Добавление ингредиентов"
    )
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "удалениее ингредиентов ",
            description = " можно удалить по id"
    )
    public IngredientDTO deleteRecipe(@PathVariable("id") int id){
        return ingredientService.deleteById(id);   //метод удаления ingredients
    }
    @PutMapping("/{id}")
    @Operation(
            summary = " Редактирование ингредиентов ",
            description = "Можно редактировать по id"
    )
    public IngredientDTO editIngredient(@PathVariable("id") int id, @RequestBody Ingredient ingredient){
        return ingredientService.updateIngredient(id, ingredient);
    }




}
