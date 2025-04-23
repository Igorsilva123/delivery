package com.example.onepot.controller;

import com.example.onepot.dto.FoodPutDTO;
import com.example.onepot.dto.FoodRequestDTO;
import com.example.onepot.dto.FoodResponseDTO;

import com.example.onepot.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService service;


    @GetMapping("/all")
    public ResponseEntity <List<FoodResponseDTO>> getAll(){
        var food = service.getAll();
        return ResponseEntity.ok(food);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity saveFood(@RequestBody @Valid FoodRequestDTO data){
        service.createFood(data);
        return ResponseEntity.ok("Comida criada");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity DeleteFood(@PathVariable Long id){
        service.deleteFood(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity saveFood(@PathVariable Long id, @RequestBody @Valid FoodPutDTO dados){
        service.putFood(id, dados);
        return ResponseEntity.ok("Comida atualizada!");
    }
}
