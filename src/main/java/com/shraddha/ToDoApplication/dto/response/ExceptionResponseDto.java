package com.shraddha.ToDoApplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {

    String apiPath;
    HttpStatus statusCode;
    String errorMessage;
    LocalDateTime errorTime;
}
