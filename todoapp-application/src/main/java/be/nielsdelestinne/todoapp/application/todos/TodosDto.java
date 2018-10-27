package be.nielsdelestinne.todoapp.application.todos;

import be.nielsdelestinne.todoapp.application.Response;
import be.nielsdelestinne.todoapp.domain.todos.Todo;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class TodosDto implements Response<TodosDto> {

    private Iterable<TodoDto> todos;

    public TodosDto from(Iterable<Todo> origin) {
        this.todos = stream(origin.spliterator(), true)
                .map(todo -> new TodoDto().from(todo))
                .collect(toList());
        return this;
    }

    public Iterable<TodoDto> getTodos() {
        return todos;
    }

    @Override
    public TodosDto getValue() {
        return this;
    }
}
