package be.nielsdelestinne.todoapp.domain.todos;

import java.util.UUID;

public class Todo {

    private String id;
    private String title;
    private String body;

    private Todo() {}

    public Todo(String title, String body) {
        this(UUID.randomUUID().toString(), title, body);
    }

    /** Should only be called from inside AbstractEntity classes */
    public Todo(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
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

    @Override
    public String toString() {
        return String.format("Todo{id='%s', title='%s', body='%s'}", id, title, body);
    }
}
