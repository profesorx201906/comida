package com.unir.comida.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import com.unir.comida.persistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}