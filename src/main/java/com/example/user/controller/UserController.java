package com.example.user.controller;

import com.example.user.entity.Status;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Status addUser(@RequestBody User newUser){
        List<User> users = userService.findAll();

        System.out.println("New user: " + newUser.toString());

        for (User user : users) {
            System.out.println("Registered user: " + user.toString());

            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userService.saveUser(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/signin")
    public Status loginUser(@RequestBody User user) {
        List<User> users = userService.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userService.saveUser(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

}
