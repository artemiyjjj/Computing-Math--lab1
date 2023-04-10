package edu.compmath.utils.managing.commands.managers;

public class MathEntityManager<T> {
    private T entity;

    public MathEntityManager(T entity) {
        this.entity = entity;
    }

    public MathEntityManager() {}

    public void setEntity(T entity) {
        this.entity = entity;
    }
    public T getEntity() {
        return this.entity;
    }
}
