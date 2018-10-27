package be.nielsdelestinne.todoapp.infrastructure.todos.api;

import be.nielsdelestinne.todoapp.application.todos.TodoDto;
import be.nielsdelestinne.todoapp.application.todos.TodosDto;
import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoRequest;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    private final TodoRequestConsumer todoRequestConsumer;

    public TodoController(@Autowired TodoRequestConsumer todoRequestConsumer) {
        this.todoRequestConsumer = todoRequestConsumer;
    }

    @GetMapping
    public TodosDto getAll(@RequestParam(name = "limit", required = false) Integer limitResult) {
        return todoRequestConsumer.consume(new GetAllTodosRequest(limitResult));
    }

    @PostMapping
    public TodoDto create(@RequestBody CreateTodoRequest createTodoRequest) {
        return todoRequestConsumer.consume(createTodoRequest);
    }

}
