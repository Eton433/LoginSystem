package com.example.LoginSystem.service;
import org.springframework.stereotype.Service;
import com.example.LoginSystem.model.User;
import com.example.LoginSystem.repository.UserRepository;
import java.util.Optional;
import com.example.LoginSystem.util.JwtUtil;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    public UserService(UserRepository userRepository,JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil=jwtUtil;
    }
    public User registerUser(User user){
        return userRepository.save(user);
    }
    public String loginUser(String username,String password){
        Optional<User>userOptional=userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            if(user.getPassword().equals(password)){
                return jwtUtil.generateToken(username);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    

}
