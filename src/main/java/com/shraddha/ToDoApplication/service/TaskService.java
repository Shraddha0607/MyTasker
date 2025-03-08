package com.shraddha.ToDoApplication.service;

import com.shraddha.ToDoApplication.Model.TaskDetails;
import com.shraddha.ToDoApplication.dto.request.TaskRequestDto;
import com.shraddha.ToDoApplication.dto.response.TaskResponseDto;
import com.shraddha.ToDoApplication.exception.GlobalExceptionHandler;
import com.shraddha.ToDoApplication.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDto saveTask(TaskRequestDto taskRequestDto) {
        TaskDetails task = new TaskDetails();
        task.setTask(taskRequestDto.getTask());

        TaskDetails savedTask = taskRepository.save(task);

        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTask(savedTask.getTask());

        return taskResponseDto;
    }

    public TaskResponseDto getTask(int id) {
        TaskDetails task = taskRepository.findById(id).orElseThrow();
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTask(task.getTask());

        return taskResponseDto;

    }

    public String deleteTask(int id) {

        try {
            log.warn("You are deleting task");
            taskRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Got issue {}", e.getMessage());
        }

        return "Task deleted successfully";
    }

    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id) {
        TaskDetails existingTask = taskRepository.findById(id).orElseThrow();

        existingTask.setTask(taskRequestDto.getTask());
        existingTask.setModifiedAt(new Date());
        TaskDetails updatedTask = taskRepository.save(existingTask);

        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTask(updatedTask.getTask());

        return taskResponseDto;
    }


}
