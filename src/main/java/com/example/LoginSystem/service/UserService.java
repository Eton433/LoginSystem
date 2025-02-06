package com.example.LoginSystem.service;
import org.springframework.stereotype.Service;
import com.example.LoginSystem.model.User;
import com.example.LoginSystem.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(User user){
        return userRepository.save(user);
    }
    public boolean loginUser(String username,String password){
        Optional<User>userOptional=userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    

}
