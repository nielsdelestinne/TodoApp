package be.nielsdelestinne.todoapp.infrastructure.todos.api;

import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoRequest;
import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoUseCase;
import be.nielsdelestinne.todoapp.application.todos.TodoDto;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosRequest;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    private final CreateTodoUseCase createTodoUseCase;
    private final GetAllTodosUseCase getAllTodosUseCase;

    // TODO: Decouple the UseCases from the Controller (using a Request Bus)
    public TodoController(@Autowired CreateTodoUseCase createTodoUseCase,
                          @Autowired GetAllTodosUseCase getAllTodosUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.getAllTodosUseCase = getAllTodosUseCase;
    }

    @GetMapping
    public Iterable<TodoDto> getAll(@RequestParam(name = "limit", required = false) Integer limitResult) {
        return getAllTodosUseCase.handle(new GetAllTodosRequest(limitResult));
    }

    @PostMapping
    public TodoDto create(@RequestBody CreateTodoRequest createTodoCommand) {
        return createTodoUseCase.handle(createTodoCommand);
    }

}
