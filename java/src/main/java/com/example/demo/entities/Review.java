package com.example.demo.entities;

import java.util.List;

public class Review {
    private long id;
    private User user;
    private Restaurant restaurant;
    private List<String> dishes;
    private String description;
    private int rating;

    public Review(User user, Restaurant restaurant, int rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
    }

    public Review(User user, Restaurant restaurant, int rating, int id) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.id = id;
    }

    public Review(User user, Restaurant restaurant, int rating, List<String> dishes, String description) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.dishes = dishes;
        this.description = description;
    }

    public Review(User user, Restaurant restaurant, int rating, List<String> dishes, String description, long id) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.dishes = dishes;
        this.description = description;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }
}
