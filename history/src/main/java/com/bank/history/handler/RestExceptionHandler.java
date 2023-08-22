package com.bank.history.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.bank.history.exception.ApiError;
import com.bank.history.exception.DTOValidationException;
import com.bank.history.exception.EntityNotFoundByIdException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleException(DTOValidationException exception) {
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(EntityNotFoundByIdException exception) {
        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception exception) {
        final ApiError apiError = new ApiError(HttpStatus.BAD_GATEWAY, exception.getMessage(), exception);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}



