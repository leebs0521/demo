package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Review {

  @Id
  private Long id;
  private String content;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  private Long productId;

  public Review(Long id, String content, User user, Long productId) {
    this.id = id;
    this.content = content;
    this.user = user;
    this.productId = productId;
  }
}
