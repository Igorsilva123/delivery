package com.example.onepot.dto;

import jakarta.validation.constraints.NotNull;

public record FoodPutDTO(
        @NotNull
        Long id,
        String title,
        String description,
        String image,
        Integer price) {
}
