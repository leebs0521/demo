package com.example.demo.service;

import com.example.demo.dto.ReviewResponse;
import com.example.demo.entity.Review;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ReviewRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  public List<ReviewResponse> getReviewsByProductId(Long id, PageRequest pageRequest) {
    List<Review> reviews = reviewRepository.findAllByProductId(id, pageRequest);

    if (reviews.isEmpty()) {
      throw new NotFoundException("review not found");
    }

    return reviews.stream().map(ReviewResponse::from).collect(Collectors.toList());
  }
}
