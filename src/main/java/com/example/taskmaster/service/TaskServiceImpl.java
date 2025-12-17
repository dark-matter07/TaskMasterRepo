package com.example.taskmaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taskmaster.dto.TaskRequestDto;
import com.example.taskmaster.dto.TaskResponseDto;
import com.example.taskmaster.model.Task;
import com.example.taskmaster.repository.TaskRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequest) {
        Task task = new Task();
        mapRequestToTask(taskRequest,task);
        Task savedTask =  taskRepository.save(task);
        return mapTaskToResponse(savedTask);
    }


    @Override
    public List<TaskResponseDto> getAllTasks() {

        return taskRepository.findAll().stream()
                    .map(this::mapTaskToResponse)
                    .toList();
    }

    @Override
    public Optional<TaskResponseDto> getTaskById(Long id) {
        return taskRepository.findById(id)
                    .map(this::mapTaskToResponse);
    }

    @Override
    public Optional<TaskResponseDto> updateTask(Long id, TaskRequestDto taskRequest) {
        return taskRepository.findById(id)
                        .map(existingTask -> {
                            mapRequestToTask(taskRequest, existingTask);
                            taskRepository.save(existingTask);
                            return mapTaskToResponse(existingTask);
                        });

    }

    @Override
    public boolean deleteTask(Long id) {
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<TaskResponseDto> markAsComplete(Long id) {
        return taskRepository.findById(id)
                    .map(existingTask -> {
                        existingTask.setCompleted(true);
                        Task completedTask = taskRepository.save(existingTask);
                        return mapTaskToResponse(completedTask);
                    });
                    
    }
    
    private void mapRequestToTask(TaskRequestDto request, Task task) {
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
    }
    
    private TaskResponseDto mapTaskToResponse(Task task) {

        TaskResponseDto response = new TaskResponseDto();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setDueDate(task.getDueDate());
        response.setCompleted(task.isCompleted());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        
        return response;
    }
}
