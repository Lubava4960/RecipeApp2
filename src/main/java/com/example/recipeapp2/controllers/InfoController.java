package com.example.recipeapp2.controllers;

import com.example.recipeapp2.dto.InfoDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping
public class InfoController {
    private static final InfoDTO INFO = new InfoDTO("Lubov Martyanova", "RecipeAdd",
            LocalDate.of(2023, 3, 26), "App for managing recipes");

    @GetMapping

    public String hello() {
        return "Application is started!";
    }

    @GetMapping("/info")
    public InfoDTO info() {

        return INFO;
    }


}