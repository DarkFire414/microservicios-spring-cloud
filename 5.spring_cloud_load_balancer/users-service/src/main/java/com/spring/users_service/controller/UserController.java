package com.spring.users_service.controller;

import com.spring.users_service.dto.UserDTO;
import com.spring.users_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/posts/{userId}")
    public UserDTO getUserAndPosts(@PathVariable Long userId) {
        return userService.getUserAndPosts(userId);
    }
}
