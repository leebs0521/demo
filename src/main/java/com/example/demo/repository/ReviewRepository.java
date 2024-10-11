package com.example.demo.repository;

import com.example.demo.entity.Review;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  @Query("SELECT r FROM Review r WHERE r.productId = :productId")
  List<Review> findAllByProductId(Long productId, PageRequest pageRequest);
}
