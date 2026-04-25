package com.quickorder.reviews_service.service;

import com.quickorder.reviews_service.model.Review;
import com.quickorder.reviews_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> listar() {
        return repository.findAll();
    }

    public Review guardar(Review review) {
        return repository.save(review);
    }
}