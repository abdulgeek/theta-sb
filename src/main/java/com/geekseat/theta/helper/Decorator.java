package com.geekseat.theta.helper;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Decorator<T> {

    public T decorate(T entity) {
        return entity;
    }

    public Iterable<T> decorate(Iterable<T> entityList) {
        for (T entity : entityList) {
            decorate(entity);
        }
        return entityList;
    }

}
