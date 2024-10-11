package com.example.demo.dto;

import com.example.demo.entity.Review;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReviewResponse {

  String content;
  String userName;

  public ReviewResponse(String content, String userName) {
    this.content = content;
    this.userName = userName;
  }

  public static ReviewResponse from(Review review) {
    return new ReviewResponse(review.getContent(), review.getUser().getUserName());
  }
}
