package com.example.demo.controller;

import com.example.demo.dto.ReviewResponse;
import com.example.demo.service.ReviewService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService reviewService;

  @GetMapping("/product/{id}")
  public ResponseEntity<?> getReviewsByProductId(
      @PathVariable Long id,
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "10") int limit) {

    PageRequest pageRequest = PageRequest.of(page, limit);

    List<ReviewResponse> reviews = reviewService.getReviewsByProductId(id, pageRequest);

    return ResponseEntity.ok(Map.of("reviews", reviews));
  }

}
