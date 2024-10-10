package com.unir.comida.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}