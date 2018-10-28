package be.nielsdelestinne.todoapp.infrastructure.todos.entities;

import be.nielsdelestinne.todoapp.domain.todos.Todo;
import be.nielsdelestinne.todoapp.infrastructure.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class TodoEntity extends AbstractEntity<Todo> {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    private TodoEntity() {}

    public TodoEntity(Todo domainObject) {
        super(domainObject);
    }

    @Override
    protected void mapDomainToEntity(Todo domainObject) {
        id = domainObject.getId();
        title = domainObject.getTitle();
        body = domainObject.getBody();
    }

    @Override
    public Todo mapEntityToDomain() {
        return new Todo(id, title, body);
    }
}
