package com.quickorder.reviews_service.controller;

import com.quickorder.reviews_service.model.Review;
import com.quickorder.reviews_service.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<Review> listar() {
        return service.listar();
    }

    @PostMapping
    public Review guardar(@RequestBody Review review) {
        return service.guardar(review);
    }
}