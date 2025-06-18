package com.monstershop.backend.dtos.review;

public class ReviewResponse {
    private Long id;
    private String username;
    private double rating;
    private String body;

    public ReviewResponse(Long id, String username, double rating, String body) {
        this.id = id;
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    // Getters only
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public double getRating() { return rating; }
    public String getBody() { return body; }
}