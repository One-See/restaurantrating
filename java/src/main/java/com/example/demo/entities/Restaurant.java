package com.example.demo.entities;

public class Restaurant {
    private long id;
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getRestaurantName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + "]";
    }
}
