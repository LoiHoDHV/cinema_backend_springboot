package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.foodDomain.Combo;
import com.example.cinema_3.dto.FoodComboDTO;
import com.example.cinema_3.dto.responseDTO.ComboFoodDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {

}
