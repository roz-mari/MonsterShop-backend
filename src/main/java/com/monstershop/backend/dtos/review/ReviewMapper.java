package com.monstershop.backend.dtos.review;

import com.monstershop.backend.dtos.review.ReviewRequest;
import com.monstershop.backend.dtos.review.ReviewResponse;
import com.monstershop.backend.models.Product;
import com.monstershop.backend.models.Review;

public class ReviewMapper {

    public static Review toEntity(ReviewRequest dto) {
        Review review = new Review();
        review.setUsername(dto.getUsername());
        review.setRating(dto.getRating());
        review.setBody(dto.getBody());
        return review;

    }

    public static ReviewResponse toDto(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getUsername(),
                review.getRating(),
                review.getBody()
        );
    }
}