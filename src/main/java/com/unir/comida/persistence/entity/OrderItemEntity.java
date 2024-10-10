package com.unir.comida.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
  @Id
  @Column(name = "id_order", nullable = false)
  private Integer idOrder;

  @Id
  @Column(name = "id_item", nullable = false)
  private Integer idItem;

  @Column(name = "id_food", nullable = false)
  private Integer idFood;

  @Column(nullable = false, columnDefinition = "Decimal(2,1)")
  private Double quantity;

  @Column(nullable = false, columnDefinition = "Decimal(5,2)")
  private Double price;
}