package com.unir.comida.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import com.unir.comida.persistence.entity.OrderEntity;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
  List<OrderEntity> findAllByDateAfter(LocalDateTime date);

  List<OrderEntity> findAllByMethodIn(List<String> methods);
}