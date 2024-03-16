package todo.spring.todospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;

}