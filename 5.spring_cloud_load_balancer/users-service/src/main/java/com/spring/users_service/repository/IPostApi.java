package com.spring.users_service.repository;

import com.spring.users_service.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-service")
public interface IPostApi {

    @GetMapping("/posts/{userId}")
    public List<PostDTO> getPostsByUserId(@PathVariable Long userId);

}
