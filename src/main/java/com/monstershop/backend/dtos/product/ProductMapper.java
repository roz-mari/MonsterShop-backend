package com.monstershop.backend.dtos.product;

import com.monstershop.backend.models.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImageUrl());
        product.setFeatured(dto.isFeatured());
        product.setRating(0.0);
        product.setReviewCount(0);
        return product;
    }

    public static ProductResponse toDto(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getRating(),
                product.getReviewCount(),
                product.isFeatured()
        );
    }
}