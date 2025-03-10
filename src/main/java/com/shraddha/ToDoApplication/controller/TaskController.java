package com.shraddha.ToDoApplication.controller;

import com.shraddha.ToDoApplication.ToDoApplication;
import com.shraddha.ToDoApplication.dto.request.TaskRequestDto;
import com.shraddha.ToDoApplication.dto.response.TaskResponseDto;
//import com.shraddha.ToDoApplication.exception.GlobalExceptionHandler;
import com.shraddha.ToDoApplication.exception.IdNotFoundException;
import com.shraddha.ToDoApplication.service.TaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/task")
@Validated
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Object> addTask(@Valid @RequestBody TaskRequestDto taskRequestDto){
        try {
            TaskResponseDto taskResponseDto = taskService.saveTask(taskRequestDto);
            return new ResponseEntity<>(taskResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while creating task at {}: {}", Instant.now(), e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}" )
    public ResponseEntity<Object> getTask(@PathVariable int id){
        try{
            System.out.println(("fghj"));
            TaskResponseDto taskResponseDto = taskService.getTask(id);
            return new ResponseEntity<Object>(taskResponseDto, HttpStatus.OK);
        }catch(IdNotFoundException e){
            log.error("{}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
        try{
            String response = taskService.deleteTask(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(IdNotFoundException e){
            log.error("{}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody TaskRequestDto taskRequestDto, @PathVariable int id){
        try{
            System.out.println("controler hitt");
            TaskResponseDto taskResponseDto = taskService.updateTask(taskRequestDto, id);
            return new ResponseEntity<>(taskResponseDto, HttpStatus.OK);
        }catch(IdNotFoundException e){
            log.error("{}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> markTaskToComplete(@PathVariable int id){
        try{
            TaskResponseDto taskResponseDto = taskService.markTaskToComplete(id);
            return new ResponseEntity<>(taskResponseDto, HttpStatus.OK);
        }catch(IdNotFoundException e){
            log.error("{}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

