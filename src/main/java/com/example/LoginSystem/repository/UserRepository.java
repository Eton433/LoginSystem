package com.example.LoginSystem.repository;
import com.example.LoginSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{

}