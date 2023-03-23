package com.example.recipeapp2.controllers;

@RestController

@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD-оперцации и  другие эдпоинды для работы с рецептами")
public class RecipeController {


    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){

        this.recipeService = recipeService;
    }

    @GetMapping
    @Operation(
            description = "Получение всех рецептов"
    )

    public List<RecipeDTO>getRecipes(){

        return recipeService.getAllRecipes();
    }
    @GetMapping ("/{id}")


    @Operation(
            summary = "Получение рецепта",
            description = "Возможно по id"
    )
    public RecipeDTO getRecipe(@PathVariable("id")int id){

        return recipeService.getRecipe(id);
    }
    @PostMapping
    @Operation(
            description = "ВОзможно добавить рецпты"
    )
    public RecipeDTO addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Редактирование рецепта",
            description = "Возможно по id "
    )
    public   RecipeDTO editRecipe(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return RecipeService.updateRecipe(id, recipe);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Можно удалить рецепт",
            description = " по id"
    )
    public  RecipeDTO deleteRecipe(@PathVariable("id") Integer id){
        return recipeService.deleteDyId(id);
    }

}

