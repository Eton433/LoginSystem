package com.example.LoginSystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.LoginSystem.model.User;


import com.example.LoginSystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public boolean loginUser(@RequestBody User user){
        return userService.loginUser(user.getUsername(), user.getPassword());
    }
}
