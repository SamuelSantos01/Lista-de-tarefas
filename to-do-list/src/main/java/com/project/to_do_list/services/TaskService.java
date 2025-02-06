package com.project.to_do_list.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.to_do_list.DTO.TaskDTO;
import com.project.to_do_list.Models.Task;
import com.project.to_do_list.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private Task convertEntity(TaskDTO taskDTO){
        
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.getCompleted());
        task.setDueDate(taskDTO.getDueDate());

        return task;
    }


    public void createTask(TaskDTO taksDTO){
        Task task = convertEntity(taksDTO);
        taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id){
        return taskRepository.findById(id);
    }

    public boolean deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Task> updateTask(Long id, TaskDTO updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.getCompleted());
            return Optional.of(taskRepository.save(task));
        }
        
        return Optional.empty();
    }
}
