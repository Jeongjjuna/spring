package com.jeongjjuna.restfulwebservices.jpa;

import com.jeongjjuna.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}