package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public List<String> getAllCategories(String sort) {

    if (!sort.equals("id") && !sort.equals("name")) {
      throw new BadRequestException("invalid sort");
    }

    List<Category> categories = categoryRepository.findAll(Sort.by(sort));

    return categories.stream().map(Category::getName).collect(Collectors.toList());
  }

  public String getCategoryById(Long id) {

    Category category = categoryRepository.findById(id).orElseThrow(
        () -> new NotFoundException("category not found")
    );

    return category.getName();
  }
}
