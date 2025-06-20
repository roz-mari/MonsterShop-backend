package com.monstershop.backend.services;

import com.monstershop.backend.dtos.review.ReviewMapper;
import com.monstershop.backend.dtos.review.ReviewRequest;
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

    public Review createReview(ReviewRequest reviewRequest) {
       Long productId = reviewRequest.getProductId();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Review review = ReviewMapper.toEntity(reviewRequest);
        review.setProduct(product);
        Review savedReview = reviewRepository.save(review);

       // updateProductRating(product); // обновляем рейтинг продукта

        return savedReview;
    }

    private void updateProductRating(Product product) {
        List<Review> reviews = reviewRepository.findByProductId(product.getId());

        double average = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        product.setRating(average);
        product.setReviewCount(reviews.size());
        productRepository.save(product);
    }
}