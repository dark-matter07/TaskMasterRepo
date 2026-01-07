package com.example.taskmaster.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TaskResponseDto {

    private Long id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
