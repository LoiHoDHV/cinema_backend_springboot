package com.example.cinema_3.Services;

import com.example.cinema_3.Repositories.ComboFoodRepository;
import com.example.cinema_3.Repositories.ComboRepository;
import com.example.cinema_3.Repositories.FoodRepository;
import com.example.cinema_3.domain.foodDomain.Combo;
import com.example.cinema_3.domain.foodDomain.ComboFood;
import com.example.cinema_3.domain.foodDomain.ComboFoodId;
import com.example.cinema_3.domain.foodDomain.Food;
import com.example.cinema_3.dto.FoodComboDTO;
import com.example.cinema_3.dto.responseDTO.ComboFoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.*;
import java.util.zip.Inflater;


@Service
public class ComboFoodServices {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    ComboRepository comboRepository;

    @Autowired
    ComboFoodRepository comboFoodRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    private ModelMapper mapper;

    public List<Combo> getAllFoodCombo() {

        System.out.println("Hehe");
        List<Combo> listCombo = comboRepository.findAll();
        return listCombo;
    }




    // Create a new domain for that, this approach wrong totally

    @Transactional
    public Combo createACombo(FoodComboDTO foodComboDTO) {

        // tao moi combo
        // tru gia tri du lieu quantity trong bang food
        // them moi vao ban

        Combo combo = mapper.map(foodComboDTO, Combo.class);
        combo = comboRepository.save(combo);

        Map<Integer, Integer> foodComboMap = foodComboDTO.getFoodInCombo();


        for(Map.Entry<Integer, Integer> entry: foodComboMap.entrySet()){
            Integer foodId = entry.getKey();
            Integer foodQuantity = entry.getValue();

            Food food = foodRepository.findById(Long.valueOf(foodId)).orElseThrow(() -> new EntityNotFoundException("Food Not Found"));
            // decrease the quantity of the food in the database
            if(food.getFoodQuantity() < foodQuantity){
                throw new RuntimeException("Not Enough quantity of food: " + food.getFoodName());

            }

            combo.addFoodCombo(food, foodQuantity);

        }


        // find the food
        return null;
    }
}
