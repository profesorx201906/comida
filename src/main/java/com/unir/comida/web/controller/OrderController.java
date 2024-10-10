package com.unir.comida.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.comida.persistence.entity.OrderEntity;
import com.unir.comida.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderEntity>> getAll() {
    return ResponseEntity.ok(this.orderService.getAll());
  }
}
