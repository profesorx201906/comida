package com.unir.comida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.comida.persistence.entity.OrderEntity;
import com.unir.comida.persistence.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
  private static final String DELIVERY = "D";
  private static final String CARRYOUT = "C";
  @Autowired
  private OrderRepository orderRepository;

  public List<OrderEntity> getAll() {
    return this.orderRepository.findAll();
  }

  public List<OrderEntity> getTodayOrders() {
    LocalDateTime today = LocalDate.now().atTime(0, 0);
    return this.orderRepository.findAllByDateAfter(today);
  }

  public List<OrderEntity> getOutsideOrders() {
    List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
    return this.orderRepository.findAllByMethodIn(methods);
  }
}