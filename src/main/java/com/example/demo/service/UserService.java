package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User newUser = new User(username, encodedPassword, "USER", 0.0);
        UserRepository.save(newUser);
    }

    public boolean authenticateUser(String username, String password) {
        User user = UserRepository.findByUsername(username);
        if (user != null) {
            passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
