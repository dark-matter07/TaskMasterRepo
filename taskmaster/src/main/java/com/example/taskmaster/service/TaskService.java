package com.example.taskmaster.service;


import java.util.List;
import java.util.Optional;

import com.example.taskmaster.dto.TaskRequestDto;
import com.example.taskmaster.dto.TaskResponseDto;


public interface TaskService {
    
    TaskResponseDto createTask (TaskRequestDto taskRequest);

    List<TaskResponseDto> getAllTasks();

    Optional<TaskResponseDto> getTaskById(Long id);

    Optional<TaskResponseDto> updateTask(Long id, TaskRequestDto taskRequest);

    boolean deleteTask(Long id);

    Optional<TaskResponseDto> markAsComplete(Long id);
}
