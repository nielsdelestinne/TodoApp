package be.nielsdelestinne.todoapp.domain.todos;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    private String id;
    private String title;
    private String body;

    private Todo() {}

    public Todo(String title, String body) {
        id = UUID.randomUUID().toString();
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
