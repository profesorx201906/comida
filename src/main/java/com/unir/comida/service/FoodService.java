package com.unir.comida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unir.comida.persistence.entity.FoodEntity;
import com.unir.comida.persistence.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {
  @Autowired
  private FoodRepository foodRepository;

  public List<FoodEntity> getAll() {
    return this.foodRepository.findAll();
  }

  public List<FoodEntity> getAvailable() {
    return this.foodRepository.findAllByAvailableTrueOrderByPrice();
  }

  public FoodEntity getByName(String name) {
    return this.foodRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
  }

  public List<FoodEntity> getAvailableVeganVegetarian() {
    return this.foodRepository.findAllByAvailableTrueAndVeganTrueOrVegetarianTrue();
  }

  public FoodEntity get(int idFood) {
    return this.foodRepository.findById(idFood).orElse(null);
  }

  public FoodEntity save(FoodEntity food) {
    return this.foodRepository.save(food);
  }

  public boolean exists(int idFood) {
    return this.foodRepository.existsById(idFood);
  }
}