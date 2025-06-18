package com.monstershop.backend.controllers;

import com.monstershop.backend.dtos.review.ReviewRequest;
import com.monstershop.backend.dtos.review.ReviewResponse;
import com.monstershop.backend.dtos.review.ReviewMapper;
import com.monstershop.backend.models.Product;
import com.monstershop.backend.models.Review;
import com.monstershop.backend.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public List<ReviewResponse> getReviews(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId).stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReviewResponse createReview(@RequestParam Long productId, @RequestBody ReviewRequest request) {
        Review review = reviewService.createReview(productId, ReviewMapper.toEntity(request, null));
        return ReviewMapper.toDto(review);
    }
}