package com.spring.posts_service.service;

import com.spring.posts_service.model.Post;

import java.util.List;

public interface IPostService {

    List<Post> getPostsByUserId(Long userId);
}
