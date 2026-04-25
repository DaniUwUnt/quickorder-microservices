package com.quickorder.reviews_service.repository;

import com.quickorder.reviews_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}