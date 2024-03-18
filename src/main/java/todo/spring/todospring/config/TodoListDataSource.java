package todo.spring.todospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo.spring.todospring.model.Todo;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TodoListDataSource {

    @Bean
    public List<Todo> todoList() {
        List<Todo> todos = new ArrayList<>();
        return todos;
    }
}