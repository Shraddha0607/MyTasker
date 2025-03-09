package com.shraddha.ToDoApplication.service;

import com.shraddha.ToDoApplication.Model.TaskDetails;
import com.shraddha.ToDoApplication.dto.request.TaskRequestDto;
import com.shraddha.ToDoApplication.dto.response.TaskResponseDto;
//import com.shraddha.ToDoApplication.exception.GlobalExceptionHandler;
import com.shraddha.ToDoApplication.enums.Status;
import com.shraddha.ToDoApplication.exception.IdNotFoundException;
import com.shraddha.ToDoApplication.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.shraddha.ToDoApplication.Transformer.TaskTransformer.taskRequestDtoToTask;
import static com.shraddha.ToDoApplication.Transformer.TaskTransformer.taskToTaskResponseDto;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDto saveTask(TaskRequestDto taskRequestDto) {
        TaskDetails task = taskRequestDtoToTask(taskRequestDto);
        TaskDetails savedTask = taskRepository.save(task);
        return taskToTaskResponseDto(savedTask);
    }

    public TaskResponseDto getTask(int id) throws IdNotFoundException{
        Optional<TaskDetails> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new IdNotFoundException("Task id does not exist");
        }
        if(task.get().getIsActive() == 0){
            throw new IdNotFoundException("Task id does not exist");
        }
        return taskToTaskResponseDto(task.get());
    }

    public String deleteTask(int id) throws IdNotFoundException{

            Optional<TaskDetails> existingTask = taskRepository.findById(id);
            if(existingTask.isEmpty()) {
                throw new IdNotFoundException("Id not exist");
            }
        if(existingTask.get().getIsActive() == 0){
            throw new IdNotFoundException("Task id does not exist");
        }

            TaskDetails task = existingTask.get();
            task.setIsActive(0);      // just make that inactive
            taskRepository.save(task);

        return "Task deleted successfully";
    }

    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id) throws IdNotFoundException{
        System.out.println("in service enterd");
        Optional<TaskDetails> existingTask = taskRepository.findById(id);
        if(existingTask.isEmpty()) {
            throw new IdNotFoundException("Id not exist");
        }
        if(existingTask.get().getIsActive() == 0){
            throw new IdNotFoundException("Task id does not exist");
        }

        TaskDetails task = existingTask.get();
        task.setTaskTitle(taskRequestDto.getTaskTitle());
        task.setTaskDescription(taskRequestDto.getTaskDescription());
        task.setPriority(taskRequestDto.getPriority());
        task.setModifiedAt(new Date());


        TaskDetails updatedTask = taskRepository.save(task);

        return taskToTaskResponseDto(updatedTask);
    }


    public TaskResponseDto markTaskToComplete(int id) throws IdNotFoundException{
        Optional<TaskDetails> existingTask = taskRepository.findById(id);
        if(existingTask.isEmpty()) throw new IdNotFoundException("Task Id does not exist");
        if(existingTask.get().getIsActive() == 0){
            throw new IdNotFoundException("Task id does not exist");
        }

        TaskDetails task = existingTask.get();
        task.setStatus(Status.COMPLETED);
        TaskDetails updatedTask = taskRepository.save(task);

        return taskToTaskResponseDto(updatedTask);
    }
}
