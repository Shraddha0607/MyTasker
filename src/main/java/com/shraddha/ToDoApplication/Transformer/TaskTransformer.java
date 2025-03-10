package com.shraddha.ToDoApplication.Transformer;

import com.shraddha.ToDoApplication.model.TaskDetails;
import com.shraddha.ToDoApplication.dto.request.TaskRequestDto;
import com.shraddha.ToDoApplication.dto.response.TaskResponseDto;
import com.shraddha.ToDoApplication.enums.Status;

import java.util.Date;

public class TaskTransformer {

    public static TaskDetails taskRequestDtoToTask(TaskRequestDto taskRequestDto){
        return TaskDetails.builder()
                .taskTitle(taskRequestDto.getTaskTitle())
                .taskDescription(taskRequestDto.getTaskDescription())
                .priority(taskRequestDto.getPriority())
                .status(Status.INCOMPLETED)
                .createdAt(new Date())
                .modifiedAt(new Date())
                .isActive(1)
                .build();
    }

//    public static TaskDetails taskRequestDtoToTask(TaskRequestDto taskRequestDto){
//        return TaskDetails.builder()
//                .taskTitle(taskRequestDto.getTaskTitle())
//                .taskDescription(taskRequestDto.getTaskDescription())
//                .priority(taskRequestDto.getPriority())
//                .status(Status.INCOMPLETED)
//                .modifiedAt(new Date())
//                .build();
//    }

    public static TaskResponseDto taskToTaskResponseDto(TaskDetails task){
        return TaskResponseDto.builder()
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .build();
    }
}
