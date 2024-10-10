package com.unir.comida.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.comida.persistence.entity.FoodEntity;
import com.unir.comida.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
  @Autowired
  private FoodService foodService;

  @GetMapping
  public ResponseEntity<List<FoodEntity>> getAll() {
    return ResponseEntity.ok(this.foodService.getAll());
  }

  @GetMapping("/{idFood}")
  public ResponseEntity<FoodEntity> get(@PathVariable int idFood) {
    return ResponseEntity.ok(this.foodService.get(idFood));
  }

  @PostMapping
  public ResponseEntity<FoodEntity> add(@RequestBody FoodEntity food) {
    if (food.getIdFood() == null || !this.foodService.exists(food.getIdFood())) {
      return ResponseEntity.ok(this.foodService.save(food));
    }

    return ResponseEntity.badRequest().build();
  }

  @PutMapping
  public ResponseEntity<FoodEntity> update(@RequestBody FoodEntity food) {
    if (food.getIdFood() != null && this.foodService.exists(food.getIdFood())) {
      return ResponseEntity.ok(this.foodService.save(food));
    }

    return ResponseEntity.badRequest().build();
  }
}