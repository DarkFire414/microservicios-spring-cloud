package com.spring.posts_service.repository;

import com.spring.posts_service.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userId = :userId")
    List<Post> findByUserId(Long userId);

}
