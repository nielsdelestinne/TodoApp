package be.nielsdelestinne.todoapp.application;

public interface UseCase<T extends Request, R extends Response>{

    R process(T command);

}
