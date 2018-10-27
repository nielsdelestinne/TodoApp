package be.nielsdelestinne.todoapp.infrastructure.api;

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
