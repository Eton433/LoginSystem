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
        System.out.println("🔵 收到註冊請求：" + user.getUsername());

        // 🔹 記錄請求細節
        System.out.println("🔵 註冊的密碼：" + user.getPassword());
        return userService.registerUser(user);
    }
}
