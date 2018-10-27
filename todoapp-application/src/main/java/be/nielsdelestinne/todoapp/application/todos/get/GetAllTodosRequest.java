package be.nielsdelestinne.todoapp.application.todos.get;

import be.nielsdelestinne.todoapp.application.Request;

public class GetAllTodosRequest implements Request<Integer> {

    private final Integer limitResult;

    public GetAllTodosRequest(Integer limitResult) {
        this.limitResult = limitResult;
    }

    @Override
    public Integer transform() {
        return limitResult;
    }

    public Integer getLimitResult() {
        return limitResult;
    }
}
