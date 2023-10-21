package com.jeongjjuna.todobackend.todo.repository;

import com.jeongjjuna.todobackend.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUsername(String username);
}
