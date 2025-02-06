package com.project.to_do_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.to_do_list.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
