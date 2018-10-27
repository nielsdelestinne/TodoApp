package be.nielsdelestinne.todoapp.infrastructure.todos.repositories;

import be.nielsdelestinne.todoapp.domain.todos.Todo;
import be.nielsdelestinne.todoapp.domain.todos.TodoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2DatabaseTodoRepository extends TodoRepository, CrudRepository<Todo, String> {
}
