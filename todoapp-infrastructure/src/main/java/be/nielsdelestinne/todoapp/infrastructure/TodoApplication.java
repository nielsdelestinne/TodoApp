package be.nielsdelestinne.todoapp.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "be.nielsdelestinne.todoapp.infrastructure")
@EntityScan(basePackages = "be.nielsdelestinne.todoapp.infrastructure")
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}
