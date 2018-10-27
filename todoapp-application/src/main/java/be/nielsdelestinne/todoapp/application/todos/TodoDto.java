package be.nielsdelestinne.todoapp.application.todos;

import be.nielsdelestinne.todoapp.application.Response;
import be.nielsdelestinne.todoapp.domain.todos.Todo;

public class TodoDto implements Response<Todo, TodoDto> {

    private String id;
    private String title;
    private String body;

    @Override
    public TodoDto from(Todo domainObject) {
        this.id = domainObject.getId();
        this.title = domainObject.getTitle();
        this.body = domainObject.getBody();
        return this;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
