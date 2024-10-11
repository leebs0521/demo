package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {

  String name;
  int price;

  public ProductResponse(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public static ProductResponse from(Product product) {
    return new ProductResponse(product.getName(), product.getPrice());
  }
}
