package com.unir.comida.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import com.unir.comida.persistence.entity.FoodEntity;

public interface FoodRepository extends ListCrudRepository<FoodEntity, Integer> {
  List<FoodEntity> findAllByAvailableTrueOrderByPrice();

  FoodEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

  List<FoodEntity> findAllByAvailableTrueAndVeganTrueOrVegetarianTrue();

}