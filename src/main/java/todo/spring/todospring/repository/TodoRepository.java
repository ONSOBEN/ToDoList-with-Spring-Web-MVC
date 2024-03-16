package todo.spring.todospring.repository;
// TodoRepository.java
import org.springframework.stereotype.Repository;
import todo.spring.todospring.model.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private List<Todo> todoList;

    public TodoRepository(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public List<Todo> findAll() {
        return todoList;
    }

    public Optional<Todo> findById(Long id) {
        return todoList.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    public Todo save(Todo todo) {
        todo.setCreatedAt(LocalDate.now());
        todoList.add(todo);
        return todo;
    }

    public void delete(Todo todo) {
        todoList.removeIf(existingTodo -> existingTodo.getId().equals(todo.getId()));
    }

    public List<Todo> search(String task, boolean isDone) {
        return todoList.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task.toLowerCase()) ||  todo.isDone() == isDone)
                .collect(Collectors.toList());
    }
}
