package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.UserRegistrationDto;
import com.bilalberek.demo.model.User;
import com.bilalberek.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationDto registrationDto) throws Exception {
        if (userRepository.findByUsername(registrationDto.getUsername()) != null) {
            throw new Exception("Username is already taken");
        }
        if (userRepository.findByEmail(registrationDto.getEmail()) != null) {
            throw new Exception("Email is already registered");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());

        return userRepository.save(user);
    }
}
