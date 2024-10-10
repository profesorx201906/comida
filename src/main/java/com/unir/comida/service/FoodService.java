package com.unir.comida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.unir.comida.persistence.entity.FoodEntity;

import java.util.List;

@Service
public class FoodService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<FoodEntity> getAll() {
    return this.jdbcTemplate.query("SELECT * FROM food WHERE available = 1",
        new BeanPropertyRowMapper<>(FoodEntity.class));
  }
}