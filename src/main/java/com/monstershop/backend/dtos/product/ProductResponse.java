package com.monstershop.backend.dtos.product;

public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private double rating;
    private int reviewCount;
    private boolean featured;

    public ProductResponse(Long id, String name, double price, String imageUrl, double rating, int reviewCount, boolean featured) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.featured = featured;
    }

    // Getters only (read-only DTO)
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public double getRating() { return rating; }
    public int getReviewCount() { return reviewCount; }
    public boolean isFeatured() { return featured; }
}