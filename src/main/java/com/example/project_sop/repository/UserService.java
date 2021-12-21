package com.example.project_sop.repository;

import com.example.project_sop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findUser(String username) {
        return repository.findUserByUsername(username);
    }

    public User findUserByID(String _id) {
        return repository.findUserByID(_id);
    }

    public List<User> retrieveUsers() {
        return repository.findAll();
    }
    public User createUser(User user) {
        return repository.save(user);
    }
}
