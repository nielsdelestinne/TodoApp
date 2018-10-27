package be.nielsdelestinne.todoapp.application.todos.get;

import be.nielsdelestinne.todoapp.application.UseCase;
import be.nielsdelestinne.todoapp.application.todos.TodoDto;
import be.nielsdelestinne.todoapp.domain.todos.TodoRepository;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class GetAllTodosUseCase implements UseCase<GetAllTodosRequest, Iterable<TodoDto>> {

    private static final int MAX_ALLOWED_TODO_RESULTS = 25;

    private final TodoRepository todoRepository;

    public GetAllTodosUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Iterable<TodoDto> handle(GetAllTodosRequest command) {
        return stream(todoRepository.findAll().spliterator(), true)
            .limit(determineValidLimit(command))
            .map(todo -> new TodoDto().from(todo))
            .collect(toList());
    }

    private int determineValidLimit(GetAllTodosRequest command) {
        return isLimitWithinAllowedBoundaries(command) ? command.transform() :  MAX_ALLOWED_TODO_RESULTS;
    }

    private boolean isLimitWithinAllowedBoundaries(GetAllTodosRequest command) {
        return command.transform() != null
                && command.transform() > 0
                && command.transform() <= MAX_ALLOWED_TODO_RESULTS;
    }

}
