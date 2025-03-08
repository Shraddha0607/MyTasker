package com.shraddha.ToDoApplication.controller;

import com.shraddha.ToDoApplication.ToDoApplication;
import com.shraddha.ToDoApplication.dto.request.TaskRequestDto;
import com.shraddha.ToDoApplication.dto.response.TaskResponseDto;
import com.shraddha.ToDoApplication.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@Validated
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> addTask(@RequestBody TaskRequestDto taskRequestDto){
        return new ResponseEntity<>(taskService.saveTask(taskRequestDto), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}" )
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable int id){
        String http = "get";
        log.debug("it is info {}", http );
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto taskRequestDto, int id){
        return new ResponseEntity<>(taskService.updateTask(taskRequestDto, id), HttpStatus.ACCEPTED);
    }

}

