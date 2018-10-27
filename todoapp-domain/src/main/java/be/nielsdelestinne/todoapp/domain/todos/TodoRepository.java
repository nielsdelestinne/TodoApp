package be.nielsdelestinne.todoapp.domain.todos;

public interface TodoRepository {

    Todo save(Todo todoToSave);

    Iterable<Todo> findAll();

}
