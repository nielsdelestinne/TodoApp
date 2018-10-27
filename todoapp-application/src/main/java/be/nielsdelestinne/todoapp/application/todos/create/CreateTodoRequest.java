package be.nielsdelestinne.todoapp.application.todos.create;

import be.nielsdelestinne.todoapp.application.Request;
import be.nielsdelestinne.todoapp.domain.todos.Todo;

public class CreateTodoRequest implements Request<Todo> {

    private String title;
    private String body;

    private CreateTodoRequest() {}

    @Override
    public Todo transform() {
        return new Todo(title, body);
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
