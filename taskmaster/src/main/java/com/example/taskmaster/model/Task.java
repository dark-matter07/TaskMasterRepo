package com.example.taskmaster.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq_generator")
    @SequenceGenerator(name = "task_seq_generator", sequenceName = "TASK_SEQ", initialValue = 100, allocationSize = 1)
    private Long id; // (Long, auto-generated)

    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title; // (String, required)

    @Column(length = 500)
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description; // (String, optional)

    private LocalDate dueDate; // (LocalDateTime, optional)

    private boolean completed = false; // (boolean, default false)
    
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt; // (timestamps)

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt; // (timestamps)

}
