package com.bank.history.exception;

public class EntityNotFoundByIdException extends RuntimeException {
    public EntityNotFoundByIdException(Long id) {
        super("Entity with id: " + id + " not found");
    }

}
