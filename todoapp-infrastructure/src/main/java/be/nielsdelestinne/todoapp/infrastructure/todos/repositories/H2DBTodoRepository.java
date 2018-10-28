package be.nielsdelestinne.todoapp.infrastructure.todos.repositories;

import be.nielsdelestinne.todoapp.domain.todos.Todo;
import be.nielsdelestinne.todoapp.domain.todos.TodoRepository;
import be.nielsdelestinne.todoapp.infrastructure.AbstractEntity;
import be.nielsdelestinne.todoapp.infrastructure.todos.entities.TodoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static java.util.stream.Collectors.toList;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Repository
public class H2DBTodoRepository implements TodoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(value = REQUIRED)
    public Todo save(Todo todoToSave) {
        entityManager.persist(new TodoEntity(todoToSave));
        return todoToSave;
    }

    @Override
    @Transactional(value = SUPPORTS)
    public Iterable<Todo> findAll() {
        return entityManager.createQuery(
                "SELECT t FROM TodoEntity t", TodoEntity.class)
                .getResultList().stream()
                    .map(AbstractEntity::mapEntityToDomain)
                    .collect(toList());
    }
}
