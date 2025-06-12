package com.todo.api.service.impl;

import com.todo.api.model.dto.TaskAddDTO;
import com.todo.api.model.dto.TaskInfoDTO;
import com.todo.api.model.entity.TaskEntity;
import com.todo.api.repository.TaskRepository;
import com.todo.api.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void add(TaskAddDTO taskAddDTO) {
        TaskEntity toAdd = modelMapper.map(taskAddDTO, TaskEntity.class);
        taskRepository.save(toAdd);
    }
}
