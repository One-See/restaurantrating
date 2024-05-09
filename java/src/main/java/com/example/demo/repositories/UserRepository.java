package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository {
    private Map<Long, User> userMap = new HashMap<Long, User>();
    private long autoIncrementId = 1L;

    @Override
    public User save(User user) {
        User u = new User(user.getUsername(), autoIncrementId);
        userMap.put(autoIncrementId, u);
        autoIncrementId++;
        return u;
    }

    @Override
    public boolean checkIfExists(long id) {
        return userMap.containsKey(id);
    }

    @Override
    public Optional<User> fetchById(long id) {
        return Optional.of(userMap.get(id));
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        userMap.remove(id);
    }

    @Override
    public int count() {
        return userMap.size();
    }
    
}
