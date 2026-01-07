package com.example.taskmaster.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmaster.dto.TaskRequestDto;
import com.example.taskmaster.dto.TaskResponseDto;
import com.example.taskmaster.service.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // CREATE - POST /api/tasks
    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto taskRequest){
        TaskResponseDto createdTask = taskService.createTask(taskRequest); 
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);                          
    }


    // READ ALL - GET /api/tasks
    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // READ ONE - GET /api/tasks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                            .map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // UPDATE - PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @ Valid @RequestBody TaskRequestDto taskRequest) {
        return taskService.updateTask(id, taskRequest)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE - DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
            if(taskService.deleteTask(id)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
    }


    // BONUS: PATCH to mark as complete - PATCH /api/tasks/{id}/complete
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponseDto> markAsComplete(@PathVariable Long id){
        return taskService.markAsComplete(id)
                                .map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
}
