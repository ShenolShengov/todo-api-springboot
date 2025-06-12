package com.todo.api.model.dto;

import com.todo.api.model.enumeration.TaskStatus;
import com.todo.api.validations.ValidTaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskInputDTO implements Serializable {

    @NotNull
    @Length(min = 5, max = 50)
    private String title;

    @NotNull
    @Length(min = 5, max = 300)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dueDate;

    @ValidTaskStatus
    private TaskStatus taskStatus;
}
