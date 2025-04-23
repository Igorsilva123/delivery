package com.example.onepot.dto;

import com.example.onepot.entities.Food.Food;

public record FoodResponseDTO(Long id, String title, String description, String image, Integer price) {

    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getDescription(),food.getImage(), food.getPrice());
    }
}


