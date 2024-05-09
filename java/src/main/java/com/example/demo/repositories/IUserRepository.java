package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;

public interface IUserRepository {
    User save(User user);
    boolean checkIfExists(long id);
    Optional<User> fetchById(long id);
    List<User> findAll();
    void deleteById(long id);
    int count();
}
