package be.nielsdelestinne.todoapp.application;

public interface Request<R> {

    R transform();

}
