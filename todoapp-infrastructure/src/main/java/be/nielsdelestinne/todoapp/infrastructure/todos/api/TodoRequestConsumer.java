package be.nielsdelestinne.todoapp.infrastructure.todos.api;

import be.nielsdelestinne.todoapp.application.todos.TodoDto;
import be.nielsdelestinne.todoapp.application.todos.TodosDto;
import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoRequest;
import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoUseCase;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosRequest;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosUseCase;
import be.nielsdelestinne.todoapp.infrastructure.RequestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoRequestConsumer extends RequestConsumer {

    private final CreateTodoUseCase createTodoUseCase;
    private final GetAllTodosUseCase getAllTodosUseCase;

    public TodoRequestConsumer(@Autowired CreateTodoUseCase createTodoUseCase,
                               @Autowired GetAllTodosUseCase getAllTodosUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.getAllTodosUseCase = getAllTodosUseCase;
    }

    TodosDto consume(GetAllTodosRequest request) {
        return doConsume(getAllTodosUseCase, request);
    }

    TodoDto consume(CreateTodoRequest request) {
        return doConsume(createTodoUseCase, request);
    }
}
