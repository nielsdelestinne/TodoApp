package be.nielsdelestinne.todoapp.infrastructure.todos;

import be.nielsdelestinne.todoapp.application.todos.create.CreateTodoUseCase;
import be.nielsdelestinne.todoapp.application.todos.get.GetAllTodosUseCase;
import be.nielsdelestinne.todoapp.infrastructure.todos.repositories.H2DBTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoUseCasesBeanConfiguration {

    private H2DBTodoRepository h2DBTodoRepository;

    public TodoUseCasesBeanConfiguration(@Autowired H2DBTodoRepository h2DBTodoRepository) {
        this.h2DBTodoRepository = h2DBTodoRepository;
    }

    @Bean
    public CreateTodoUseCase createTodoUseCase() {
        return new CreateTodoUseCase(h2DBTodoRepository);
    }

    @Bean
    public GetAllTodosUseCase getAllTodosUseCase() {
        return new GetAllTodosUseCase(h2DBTodoRepository);
    }

}
