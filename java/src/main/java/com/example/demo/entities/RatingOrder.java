package com.example.demo.entities;

public enum RatingOrder {

    RATING_ASC("RATING_ASC"), RATING_DESC("RATING_DESC");
    
    private String name;

    private RatingOrder(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
