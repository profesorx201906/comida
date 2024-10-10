package com.unir.comida.persistence.repository;


import org.springframework.data.repository.ListCrudRepository;
import com.unir.comida.persistence.entity.FoodEntity;

public interface FoodRepository extends ListCrudRepository<FoodEntity, Integer> {
}