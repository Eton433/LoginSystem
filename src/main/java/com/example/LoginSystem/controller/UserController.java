package com.example.LoginSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.LoginSystem.model.User;

import com.example.LoginSystem.service.UserService;
import com.example.LoginSystem.util.JwtUtil;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private JwtUtil jwtUtil;

    public UserController(UserService userService ,JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        String token = userService.loginUser(user.getUsername(), user.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        boolean isValid = jwtUtil.validateToken(token);

        if (isValid) {
            return ResponseEntity.ok("Token is valid!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token!");
        }
    }
}
