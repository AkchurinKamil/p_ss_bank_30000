package com.bank.history.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationResult {
    public String handleBindingResult(BindingResult bindingResult) {
        final StringBuilder errorMessage = new StringBuilder();
        final List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError error : errors) {
            errorMessage.append(error.getDefaultMessage()).append("\n");
        }
        return String.valueOf(errorMessage);
    }

}
