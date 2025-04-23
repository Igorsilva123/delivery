package com.example.onepot.repositories;

import com.example.onepot.entities.Food.Food;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FoodRepository extends JpaRepository<Food, Long>{

}