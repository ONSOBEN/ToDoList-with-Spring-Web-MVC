package todo.spring.todospring.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;

}