package com.unir.comida.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
public class FoodEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_food", nullable = false)
  private Integer idFood;

  @Column(nullable = false, length = 30, unique = true)
  private String name;

  @Column(nullable = false, length = 150)
  private String description;

  @Column(nullable = false, columnDefinition = "Decimal(5,2)")
  private Double price;

  @Column(columnDefinition = "TINYINT")
  private Boolean vegetarian;

  @Column(columnDefinition = "TINYINT")
  private Boolean vegan;

  @Column(columnDefinition = "TINYINT", nullable = false)
  private Boolean available;
}