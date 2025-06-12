package com.todo.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskIfoDTO implements Serializable {

    private String title;
    private LocalDateTime dueDate;
}
