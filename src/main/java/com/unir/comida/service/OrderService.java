package com.unir.comida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.comida.persistence.entity.OrderEntity;
import com.unir.comida.persistence.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAll() {
        return this.orderRepository.findAll();
    }
}