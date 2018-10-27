package be.nielsdelestinne.todoapp.application.todos.create;

import be.nielsdelestinne.todoapp.application.Response;
import be.nielsdelestinne.todoapp.application.UseCase;
import be.nielsdelestinne.todoapp.application.todos.TodoDto;
import be.nielsdelestinne.todoapp.domain.todos.Todo;
import be.nielsdelestinne.todoapp.domain.todos.TodoRepository;

public class CreateTodoUseCase implements UseCase<CreateTodoRequest, Response<TodoDto>> {

    private final TodoRepository todoRepository;

    public CreateTodoUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDto process(CreateTodoRequest command) {
        Todo savedTodo = todoRepository.save(command.transform());
        return new TodoDto().from(savedTodo);
    }
}
