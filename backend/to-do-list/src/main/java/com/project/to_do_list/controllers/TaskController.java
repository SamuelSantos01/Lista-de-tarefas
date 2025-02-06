package com.project.to_do_list.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.to_do_list.DTO.TaskDTO;
import com.project.to_do_list.Models.Task;
import com.project.to_do_list.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
        try {
            if (taskDTO == null || taskDTO.getTitle() == null || taskDTO.getDescription() == null) {
                return new ResponseEntity<>("Invalid task data", HttpStatus.BAD_REQUEST);
            }
            taskService.createTask(taskDTO);
            return new ResponseEntity<>("Task created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating task: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        try {
            List<Task> tasks = taskService.getTasks();
            if (tasks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        try {
            Optional<Task> task = taskService.getTask(id);
            if (task.isPresent()) {
                return new ResponseEntity<>(task.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        try {
            boolean deleted = taskService.deleteTaskById(id);
            if (deleted) {
                return new ResponseEntity<>("Task deleted successfully", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting task: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskDTO updatedTask) {
        try {
            if (updatedTask == null || updatedTask.getTitle() == null || updatedTask.getDescription() == null) {
                return new ResponseEntity<>("Invalid task data", HttpStatus.BAD_REQUEST);
            }
            Optional<Task> task = taskService.updateTask(id, updatedTask);
            if (task.isPresent()) {
                return new ResponseEntity<>("Task updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating task: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
