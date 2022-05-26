package com.example.pecanecommerce.Services;

import java.util.Optional;

import com.example.pecanecommerce.Models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);
    User getUser(String email);
    Optional<User> findById(Integer id);
}
