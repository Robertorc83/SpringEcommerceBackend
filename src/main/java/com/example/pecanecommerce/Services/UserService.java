package com.example.pecanecommerce.Services;

import com.example.pecanecommerce.Models.User;

public interface UserService {

    User saveUser(User user);
    User getUser(String email);
}
