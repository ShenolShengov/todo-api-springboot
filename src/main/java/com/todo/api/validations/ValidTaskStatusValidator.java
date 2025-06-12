package com.todo.api.validations;

import com.todo.api.model.enumeration.TaskStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidTaskStatusValidator implements ConstraintValidator<ValidTaskStatus, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return false;
        return Arrays.stream(TaskStatus.values()).anyMatch(status -> status.name().equals(s));
    }
}
