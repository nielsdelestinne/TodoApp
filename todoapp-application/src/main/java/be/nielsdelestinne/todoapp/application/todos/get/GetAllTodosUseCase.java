package be.nielsdelestinne.todoapp.application.todos.get;

import be.nielsdelestinne.todoapp.application.Response;
import be.nielsdelestinne.todoapp.application.UseCase;
import be.nielsdelestinne.todoapp.application.todos.TodosDto;
import be.nielsdelestinne.todoapp.domain.todos.Todo;
import be.nielsdelestinne.todoapp.domain.todos.TodoRepository;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class GetAllTodosUseCase implements UseCase<GetAllTodosRequest, Response<TodosDto>> {

    private static final int MAX_ALLOWED_TODO_RESULTS = 25;

    private final TodoRepository todoRepository;

    public GetAllTodosUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodosDto process(GetAllTodosRequest command) {
        return new TodosDto()
                .from(stream(todoRepository.findAll().spliterator(), true)
                        .limit(determineValidLimit(command))
                        .collect(toList()));
    }

    private int determineValidLimit(GetAllTodosRequest command) {
        return isLimitWithinAllowedBoundaries(command) ? command.transform() : MAX_ALLOWED_TODO_RESULTS;
    }

    private boolean isLimitWithinAllowedBoundaries(GetAllTodosRequest command) {
        return command.transform() != null
                && command.transform() > 0
                && command.transform() <= MAX_ALLOWED_TODO_RESULTS;
    }

}
