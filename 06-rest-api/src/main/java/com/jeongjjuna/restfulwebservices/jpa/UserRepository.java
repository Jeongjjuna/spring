package com.jeongjjuna.restfulwebservices.jpa;

import com.jeongjjuna.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
