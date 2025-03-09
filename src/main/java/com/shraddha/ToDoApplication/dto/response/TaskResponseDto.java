package com.shraddha.ToDoApplication.dto.response;

import com.shraddha.ToDoApplication.enums.Priority;
import com.shraddha.ToDoApplication.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskResponseDto {
    String taskTitle ;
    String taskDescription;
    Priority priority;
    Status status;
}