package com.example.onepot.service;


import com.example.onepot.dto.FoodPutDTO;
import com.example.onepot.dto.FoodRequestDTO;
import com.example.onepot.dto.FoodResponseDTO;
import com.example.onepot.entities.Food.Food;
import com.example.onepot.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository repository;

    public List<FoodResponseDTO> getAll(){
        var foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @Transactional
    public void createFood(FoodRequestDTO foodData) {
        repository.save(new Food(foodData));
    }

    @Transactional
    public void deleteFood(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Food putFood(Long id, FoodPutDTO data) {
        var food = repository.getReferenceById(id);
        food.atualizar(data);
        return food;

    }
}

