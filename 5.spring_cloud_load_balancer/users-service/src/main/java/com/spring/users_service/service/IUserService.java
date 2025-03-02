package com.spring.users_service.service;

import com.spring.users_service.dto.UserDTO;

public interface IUserService {
    public UserDTO getUserAndPosts(Long userId);
}
