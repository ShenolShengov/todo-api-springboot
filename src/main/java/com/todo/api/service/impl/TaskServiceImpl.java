package com.todo.api.service.impl;

import com.todo.api.model.dto.TaskInfoDTO;
import com.todo.api.model.dto.TaskInputDTO;
import com.todo.api.model.entity.TaskEntity;
import com.todo.api.repository.TaskRepository;
import com.todo.api.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskInfoDTO> getAll() {
        return taskRepository.findAll().stream().map(t -> modelMapper.map(t, TaskInfoDTO.class))
                .toList();
    }

    @Override
    public void add(TaskInputDTO taskInputDTO) {
        TaskEntity toAdd = modelMapper.map(taskInputDTO, TaskEntity.class);
        taskRepository.save(toAdd);
    }

    @Override
    public void update(TaskInputDTO taskInputDTO, Long id) {
        TaskEntity updated = modelMapper.map(taskInputDTO, TaskEntity.class);
        updated.setId(id);
        taskRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        TaskEntity toDelete = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        taskRepository.delete(toDelete);
    }
}
