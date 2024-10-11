package com.example.demo.controller;

import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<?> getProducts(
      @RequestParam(required = false, defaultValue = "id") String sort) {
    List<ProductResponse> products = productService.getProducts(sort);
    return ResponseEntity.ok(Map.of("products", products));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable Long id) {
    ProductResponse product = productService.getProductById(id);

    return ResponseEntity.ok(product);
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<?> getProductByCategoryId(
      @PathVariable Long id,
      @RequestParam(required = false, defaultValue = "id") String sort) {
    List<ProductResponse> products = productService.getProductByCategoryId(id, sort);
    return ResponseEntity.ok(Map.of("products", products));
  }
}
