package com.spring.users_service.service;

import com.spring.users_service.dto.PostDTO;
import com.spring.users_service.dto.UserDTO;
import com.spring.users_service.model.User;
import com.spring.users_service.repository.IPostApi;
import com.spring.users_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostApi postApi;

    @Override
    public UserDTO getUserAndPosts(Long userId) {
        // Datos del usuario de la BD
        User user = userRepository.findById(userId).orElse(null);

        // Datos de los posts del usuario
        //   Obtener Posts desde el servicio de Posts
        List<PostDTO> posts = postApi.getPostsByUserId(userId);

        //   Crear un UserDTO con los datos del usuario y los posts
        if (user != null) {
            return new UserDTO(user.getUserId(), user.getName(), user.getLastName(), user.getCellPhone(), posts);
        }
        return new UserDTO();
    }
}
