package com.unir.comida.web.controller;

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
import java.util.Map;
import java.util.HashMap;

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

  @GetMapping("/available")
  public ResponseEntity<List<FoodEntity>> getAvailable() {
    return ResponseEntity.ok(this.foodService.getAvailable());
  }

  @GetMapping("/vegantrue")
  public ResponseEntity<Map<String, String>> getCountByVeganTrue() {
    Map<String, String> response = new HashMap<>();
    response.put("cantidad", String.valueOf(this.foodService.getCountByVeganTrue()));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/veganvegetarian")
  public ResponseEntity<List<FoodEntity>> getAvailableVeganVegetarian() {
    return ResponseEntity.ok(this.foodService.getAvailableVeganVegetarian());
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<FoodEntity> getByName(@PathVariable String name) {
    return ResponseEntity.ok(this.foodService.getByName(name));
  }

  @GetMapping("/with/{ingredient}")
  public ResponseEntity<List<FoodEntity>> getWith(@PathVariable String ingredient) {
    return ResponseEntity.ok(this.foodService.getWith(ingredient));
  }

  @GetMapping("/without/{ingredient}")
  public ResponseEntity<List<FoodEntity>> getWithout(@PathVariable String ingredient) {
    return ResponseEntity.ok(this.foodService.getWithout(ingredient));
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