package com.example.cinema_3.Services;

import com.example.cinema_3.Repositories.FoodRepository;
import com.example.cinema_3.domain.Food;
import com.example.cinema_3.dto.FoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
@Service
public class FoodServices {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }
    public Food save(FoodDTO foodDTO){
        Food saveFood = mapper.map(foodDTO, Food.class);
        System.out.println("DEBUG");


        return foodRepository.save(saveFood);


    }

    public Food findFoodById(Long id){
        Optional<Food> foodFind = foodRepository.findById(id);
        try{
            Food foodReturn = foodFind.get();
            return foodReturn;
        }catch(NoSuchElementException e){
            return null;
        }

    }

}
