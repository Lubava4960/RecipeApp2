package com.example.recipeapp2.dto;

import java.time.LocalDate;

public record InfoDTO(String author, String name, LocalDate creationDate, String description) {

}

