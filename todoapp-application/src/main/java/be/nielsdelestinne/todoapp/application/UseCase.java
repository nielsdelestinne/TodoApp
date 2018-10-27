package be.nielsdelestinne.todoapp.application;

public interface UseCase<T extends Request, R>{

    R handle(T command);

}
