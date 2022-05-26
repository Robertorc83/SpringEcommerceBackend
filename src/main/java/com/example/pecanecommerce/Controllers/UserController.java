package com.example.pecanecommerce.Controllers;

import com.example.pecanecommerce.Models.User;
import com.example.pecanecommerce.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        logger.info("User register: {}", user);
        user.setType("USER");
        user.setPassword( passEncode.encode(user.getPassword()));
        userService.saveUser(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
        }
    }




