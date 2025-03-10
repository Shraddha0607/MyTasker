package com.shraddha.ToDoApplication.repository;

import com.shraddha.ToDoApplication.model.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskDetails, Integer> {
}
