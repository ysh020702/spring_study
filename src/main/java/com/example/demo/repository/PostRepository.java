package com.example.demo.repository;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Long countByUser(User user);
    List<Post> findByUser(User user);
}