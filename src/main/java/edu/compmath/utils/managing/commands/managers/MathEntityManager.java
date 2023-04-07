package edu.compmath.utils.managing.commands.managers;

public abstract class MathEntityManager<T> {
    T entity;
    public abstract void setEntity(T entity);
    public abstract T getEntity();
}
