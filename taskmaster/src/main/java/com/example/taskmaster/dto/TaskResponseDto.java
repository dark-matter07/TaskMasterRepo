package com.example.taskmaster.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskResponseDto {
    
    private Long id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
