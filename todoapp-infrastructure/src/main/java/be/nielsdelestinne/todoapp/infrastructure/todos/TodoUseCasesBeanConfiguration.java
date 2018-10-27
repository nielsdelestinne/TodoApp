package be.nielsdelestinne.todoapp.infrastructure.todos;

import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoUseCase;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosUseCase;
import be.nielsdelestinne.todoapp.infrastructure.todos.repositories.H2DatabaseTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoUseCasesBeanConfiguration {

    private H2DatabaseTodoRepository h2DatabaseTodoRepository;

    public TodoUseCasesBeanConfiguration(@Autowired H2DatabaseTodoRepository h2DatabaseTodoRepository) {
        this.h2DatabaseTodoRepository = h2DatabaseTodoRepository;
    }

    @Bean
    public CreateTodoUseCase createTodoUseCase() {
        return new CreateTodoUseCase(h2DatabaseTodoRepository);
    }

    @Bean
    public GetAllTodosUseCase getAllTodosUseCase() {
        return new GetAllTodosUseCase(h2DatabaseTodoRepository);
    }

}
