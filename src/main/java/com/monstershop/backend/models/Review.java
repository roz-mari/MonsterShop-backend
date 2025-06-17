package com.monstershop.backend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private double rating;
    private String body;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public double getRating() {
        return rating;
    }

    public String getBody() {
        return body;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
