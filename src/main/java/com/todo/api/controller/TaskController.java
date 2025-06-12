package com.todo.api.controller;

import com.todo.api.model.dto.TaskInfoDTO;
import com.todo.api.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskInfoDTO>> all() {
        List<TaskInfoDTO> all = taskService.getAll();
        return ResponseEntity.ok(all);
    }
}
