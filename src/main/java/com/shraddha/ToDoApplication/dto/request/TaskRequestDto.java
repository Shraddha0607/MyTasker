package com.shraddha.ToDoApplication.dto.request;

import com.shraddha.ToDoApplication.enums.Priority;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRequestDto {
    String taskTitle ;
    String taskDescription;
    Priority priority;
}
