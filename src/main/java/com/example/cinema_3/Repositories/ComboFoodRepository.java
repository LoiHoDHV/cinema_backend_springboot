package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.foodDomain.ComboFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboFoodRepository extends JpaRepository<ComboFood, Long> {
}
