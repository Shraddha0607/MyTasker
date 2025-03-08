package com.shraddha.ToDoApplication.Model;

import com.shraddha.ToDoApplication.enums.Category;
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
    int id;

    @NotBlank(message = "Name is required")
    String task ;

    @Enumerated(value= EnumType.STRING)
    Category category;

    Date createdAt = new Date();

    Date modifiedAt;
//    int isActive=0;
}
