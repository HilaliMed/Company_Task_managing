package com.example.springtaskproject.repository;


import com.example.springtaskproject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
