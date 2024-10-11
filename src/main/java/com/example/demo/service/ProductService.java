package com.example.demo.service;

import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getProducts(String sort) {

    if (!sort.equals("name") && !sort.equals("price") && !sort.equals("id")) {
      throw new BadRequestException("invalid sort");
    }

    List<Product> products = productRepository.findAll(Sort.by(sort));

    return products.stream().map(ProductResponse::from).collect(Collectors.toList());
  }

  public ProductResponse getProductById(Long id) {
    Product product = productRepository.findById(id).orElseThrow(
        () -> new NotFoundException("product not found")
    );

    return ProductResponse.from(product);
  }

  public List<ProductResponse> getProductByCategoryId(Long id, String sort) {

    if (!sort.equals("name") && !sort.equals("price") && !sort.equals("id")) {
      throw new BadRequestException("invalid sort");
    }

    List<Product> products = productRepository.findAllByCategoryId(id, Sort.by(sort));

    if (products.isEmpty()) {
      throw new NotFoundException("category not found");
    }

    return products.stream().map(ProductResponse::from).collect(Collectors.toList());
  }
}
