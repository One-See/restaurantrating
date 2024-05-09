package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name) {
        return this.userRepository.save(new User(name));
    }

}
