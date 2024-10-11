package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {

  @Id
  private Long id;
  private String name;
  private int price;
  private Long categoryId;

  public Product(Long id, String name, int price, Long categoryId) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.categoryId = categoryId;
  }
}
