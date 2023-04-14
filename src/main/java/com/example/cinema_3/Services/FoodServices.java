package com.example.cinema_3.Services;

import com.example.cinema_3.Repositories.FoodRepository;
import com.example.cinema_3.domain.foodDomain.Food;
import com.example.cinema_3.domain.foodDomain.ComboFood;
import com.example.cinema_3.dto.FoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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


    @Transactional
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

    @Transactional
    public Food updateTheFood(Long foodId, FoodDTO foodDTO){
        Food food = foodRepository.findById(foodId)
                .orElseThrow(()-> new EntityNotFoundException("Food Not Found"));


        food = mapper.map(foodDTO, Food.class);

        food.setFoodId(foodId);

        return foodRepository.save(food);

    }
    @Transactional
    public int deleteFood(long foodId){
        try{
            foodRepository.deleteById(foodId);
            return 1;
        }catch (RuntimeException e){
            return -1;
        }
    }

}
