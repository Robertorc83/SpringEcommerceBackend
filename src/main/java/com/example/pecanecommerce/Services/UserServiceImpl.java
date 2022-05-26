package com.example.pecanecommerce.Services;

import com.example.pecanecommerce.Models.User;
import com.example.pecanecommerce.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {

        return null;
    }

	@Override
	public Optional<User> findById(Integer id) {

		return userRepository.findById(Long.valueOf(id));
	}
}
