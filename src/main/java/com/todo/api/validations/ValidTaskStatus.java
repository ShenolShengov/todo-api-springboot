package com.todo.api.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTaskStatusValidator.class)
public @interface ValidTaskStatus {

    String message() default "Invalid task status";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
