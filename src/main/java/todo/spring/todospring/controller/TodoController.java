package todo.spring.todospring.controller;

// TodoController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todo.spring.todospring.model.Todo;
import todo.spring.todospring.repository.TodoRepository;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoRepository.findById(id).orElseThrow());
        return "view";
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoRepository.findById(id).orElseThrow());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Todo todo) {
        todoRepository.save(todo); // assuming this method updates if id already exists
        return "redirect:/todo";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoRepository.delete(todoRepository.findById(id).orElseThrow());
        return "redirect:/todo";
    }

    @GetMapping("/search")
    public String search(@RequestParam String task, @RequestParam boolean isDone, Model model) {
        model.addAttribute("todos", todoRepository.search(task, isDone));
        return "redirect:/todo";
    }
}