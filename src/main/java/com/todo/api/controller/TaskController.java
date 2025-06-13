package com.todo.api.controller;

import com.todo.api.model.dto.TaskInfoDTO;
import com.todo.api.model.dto.TaskInputDTO;
import com.todo.api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping
    public void create(
            @RequestBody @Valid TaskInputDTO taskInputDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid task input");
        }

        taskService.add(taskInputDTO);
    }

    @PutMapping("/{id}")
    public void update(
            @RequestBody @Valid TaskInputDTO taskInputDTO,
            @PathVariable Long id,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid task input");
        }

        taskService.update(taskInputDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

}
