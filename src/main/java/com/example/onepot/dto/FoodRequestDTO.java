package com.example.onepot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodRequestDTO(
        @NotBlank
        String title,
        String description,
        @NotBlank
        String image,
        @NotNull @Min(1)
        Integer price) {


}
