package com.example.cinema_3.Services;

import com.example.cinema_3.Repositories.ComboFoodRepository;
import com.example.cinema_3.Repositories.ComboRepository;
import com.example.cinema_3.Repositories.FoodRepository;
import com.example.cinema_3.domain.foodDomain.Combo;
import com.example.cinema_3.domain.foodDomain.ComboFood;
import com.example.cinema_3.domain.foodDomain.Food;
import com.example.cinema_3.dto.FoodComboDTO;
import com.example.cinema_3.dto.FoodDTO;
import com.example.cinema_3.dto.responseDTO.ComboResponseDTO;
import com.example.cinema_3.dto.responseDTO.FoodResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import java.util.*;


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

    public List<ComboResponseDTO> getAllFoodCombo() {

        System.out.println("Hehe");
        List<Combo> listCombo = comboRepository.findAll();
        List<ComboResponseDTO> comboResponseDTOS = new ArrayList<>();

        for (Combo combo : listCombo) {
            ComboResponseDTO newCombo = mapper.map(combo, ComboResponseDTO.class);
            System.out.println("hehe");

            ArrayList<FoodResponseDTO> foodResponseDTOArrayList = new ArrayList<>();
            for (ComboFood comboFood : combo.getListCombo()) {
                Food foodInCombo = comboFood.getFood();
                FoodResponseDTO foodResponse = new FoodResponseDTO(foodInCombo.getFoodId(), foodInCombo.getFoodName(),
                        foodInCombo.getFoodPrice(), combo.getComboQuantity());
                foodResponseDTOArrayList.add(foodResponse);
            }

            // goi set comboResponseDTO

            newCombo.setListResponseDTOS(foodResponseDTOArrayList);

            comboResponseDTOS.add(newCombo);


        }
        return comboResponseDTOS;
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

        // should return back to the comboDTO
        // find the food
        return null;
    }

    public ComboResponseDTO getDetailsCombobyId(Long comboId){
        Combo comboDatabase = comboRepository.findById(comboId).orElseThrow(() -> new EntityNotFoundException("Combo Not Found"));

        ComboResponseDTO comboResponseDTO = mapper.map(comboDatabase, ComboResponseDTO.class);
        ArrayList<FoodResponseDTO> foodResponseDTOArrayList = new ArrayList<>();
        if(comboDatabase.getListCombo() != null && comboDatabase.getListCombo().size() != 0){
            for (ComboFood comboFood : comboDatabase.getListCombo()) {
                Food foodInCombo = comboFood.getFood();
                FoodResponseDTO foodResponse = new FoodResponseDTO(foodInCombo.getFoodId(), foodInCombo.getFoodName(),
                        foodInCombo.getFoodPrice(), comboFood.getQuantity());
                foodResponseDTOArrayList.add(foodResponse);
            }

        }

        comboResponseDTO.setListResponseDTOS(foodResponseDTOArrayList);

        return comboResponseDTO;


    }

    @Transactional
    public ComboResponseDTO updateFoodCombo(Long comboId, FoodComboDTO foodComboDTO){
        Combo combo = comboRepository.findById(comboId).orElseThrow(() -> new EntityNotFoundException("Combo not found!"));

        combo.setComboName(foodComboDTO.getComboName());
        combo.setComboDescription(foodComboDTO.getComboDescription());
        combo.setComBoDiscount(foodComboDTO.getComBoDiscount());
        combo.setComboQuantity(foodComboDTO.getComboQuantity());
        Integer comboQuantity = combo.getComboQuantity();
        // truoc khi xoa thi phai tra ve so luong cho tung san pham ve lai vi tri

//        if(combo.getListCombo() != null && combo.getListCombo().size() != 0){
//            for (ComboFood comboFood : combo.getListCombo()) {
//                Food food = comboFood.getFood();
//                Long foodQuantityInDb = food.getFoodQuantity();
//                Integer foodInComboQuantiy = comboFood.getQuantity();
//                food.setFoodQuantity(foodQuantityInDb + foodInComboQuantiy * comboQuantity);
//                foodRepository.save(food);
//            }
//
//        }
//        combo.getListCombo().clear();
//        Set<FoodDTO> foodDTOSet = foodComboDTO.getListResponseDTOS();
//        for (FoodDTO foodDTO : foodDTOSet) {
//            String foodName = foodDTO.getFoodName();
//            Optional<Food> foodOpt = foodRepository.findFoodByFoodName(foodName);
//            Food food = foodOpt.get();
//
//            Long foodId = food.getFoodId();
//            food = mapper.map(foodDTO, Food.class);
//            food.setFoodId(foodId);
//            combo.addFoodCombo(food, Math.toIntExact(foodDTO.getFoodQuantity()));
//        }
//        comboRepository.save(combo);

        if(combo.getListCombo() != null && combo.getListCombo().size() != 0){
            combo.removeFood();
        }
        comboRepository.save(combo);
        ComboResponseDTO comboResponseDTO = mapper.map(combo, ComboResponseDTO.class);

        return comboResponseDTO;




    }
}
