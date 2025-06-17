package com.monstershop.backend.services;

import com.monstershop.backend.models.Product;
import com.monstershop.backend.models.Review;
import com.monstershop.backend.repositories.ProductRepository;
import com.monstershop.backend.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review createReview(Long productId, Review review) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        review.setProduct(product);
        Review savedReview = reviewRepository.save(review);


        List<Review> reviews = reviewRepository.findByProductId(productId);
        int count = reviews.size();
        double averageRating = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        product.setReviewCount(count);
        product.setRating(averageRating);
        productRepository.save(product);

        return savedReview;
    }
}
