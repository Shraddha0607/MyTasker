package com.shraddha.ToDoApplication.model;

import com.shraddha.ToDoApplication.enums.Priority;
import com.shraddha.ToDoApplication.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Name is required")
    String taskTitle ;

    String taskDescription;

    @Enumerated(value= EnumType.ORDINAL)
    Priority priority;

    @Enumerated(value = EnumType.ORDINAL)
    Status status = Status.INCOMPLETED;

    Date createdAt = new Date();

    Date modifiedAt = new Date();
    int isActive=1;
}
