package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.foodDomain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    public Optional<Food> findFoodByFoodName(String foodName);
}
