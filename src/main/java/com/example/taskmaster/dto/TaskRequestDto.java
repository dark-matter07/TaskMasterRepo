package com.example.taskmaster.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequestDto {
    
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    private LocalDate dueDate;

    // Note: We don't allow setting 'completed' on create/update via main endpoint
    // (We'll have a separate endpoint to mark as complete)
    // Also: createdAt/updatedAt are auto-managed → not in request
}
