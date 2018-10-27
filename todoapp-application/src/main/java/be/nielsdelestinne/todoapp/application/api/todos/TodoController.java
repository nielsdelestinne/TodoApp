package be.nielsdelestinne.todoapp.application.api.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    @GetMapping
    public TodoDto[] getAll() {
        return null;
    }

    @PostMapping
    public TodoDto create(@RequestBody TodoDto todoToCreate) {
        return null;
    }

}
