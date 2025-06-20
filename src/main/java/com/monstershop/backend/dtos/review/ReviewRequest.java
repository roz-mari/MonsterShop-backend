package com.monstershop.backend.dtos.review;

public class ReviewRequest {
    private String username;
    private double rating;
    private String body;
    private Long productId;

    public String getUsername() { return username; }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setUsername(String username) { this.username = username; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}