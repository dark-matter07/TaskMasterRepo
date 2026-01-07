package com.example.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmaster.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
