package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
