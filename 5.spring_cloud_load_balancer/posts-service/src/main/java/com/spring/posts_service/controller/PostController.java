package com.spring.posts_service.controller;

import com.spring.posts_service.model.Post;
import com.spring.posts_service.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private IPostService postService;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        System.out.println("I am in the port: " + serverPort);
        return postService.getPostsByUserId(userId);
    }
}
