package org.me.mmlogo.validators.service;

public interface Validator<T> {

    boolean isValid(T t);
}
