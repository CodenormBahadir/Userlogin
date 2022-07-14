package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);

    }



}


