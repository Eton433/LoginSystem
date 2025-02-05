package com.example.LoginSystem.service;
import org.springframework.stereotype.Service;
import com.example.LoginSystem.model.User;
import com.example.LoginSystem.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(User user){
        return userRepository.save(user);
    }
    

}
