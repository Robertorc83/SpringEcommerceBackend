package com.example.pecanecommerce.Services;

import java.util.Optional;

import com.example.pecanecommerce.Models.User;

public interface UserService {

    User saveUser(User user);
    User getUser(String email);
    Optional<User> findById(Integer id);
}
