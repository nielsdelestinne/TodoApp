package be.nielsdelestinne.todoapp.application;

public interface Response<T, R> {

    R from(T domainObject);

}
