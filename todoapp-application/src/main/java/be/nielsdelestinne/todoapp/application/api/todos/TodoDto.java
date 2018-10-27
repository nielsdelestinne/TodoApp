package be.nielsdelestinne.todoapp.application.api.todos;

public class TodoDto {

    public String title;
    public String body;

    private TodoDto(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public static TodoDto of(String title, String body) {
        return new TodoDto(title, body);
    }
}
