package com.shraddha.ToDoApplication.dto.response;

import com.shraddha.ToDoApplication.enums.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskResponseDto {
    String task ;
    Category category;
}