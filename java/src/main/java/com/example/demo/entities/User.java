package com.example.demo.entities;

public class User {
    private long id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getUsername() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }
}
