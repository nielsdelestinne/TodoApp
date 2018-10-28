package be.nielsdelestinne.todoapp.infrastructure;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractEntity<T> {

    @Transient
    private T domainObject;

    protected AbstractEntity() {}

    public AbstractEntity(T domainObject) {
        this.domainObject = domainObject;
        mapDomainToEntity(domainObject);
    }

    protected abstract void mapDomainToEntity(T domainObject);
    public abstract T mapEntityToDomain();
}
