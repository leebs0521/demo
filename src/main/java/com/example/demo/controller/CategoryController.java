package com.example.demo.controller;

import com.example.demo.service.CategoryService;
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
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<?> getCategories(
      @RequestParam(required = false, defaultValue = "id") String sort) {
    List<String> categories = categoryService.getAllCategories(sort);

    return ResponseEntity.ok(Map.of("categories", categories));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
    String category = categoryService.getCategoryById(id);

    return ResponseEntity.ok(Map.of("name", category));
  }
}
