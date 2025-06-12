package com.todo.api.service;


import com.todo.api.model.dto.TaskInputDTO;
import com.todo.api.model.dto.TaskInfoDTO;

import java.util.List;

public interface TaskService {

    List<TaskInfoDTO> getAll();

    void add(TaskInputDTO taskInputDTO);

    void update(TaskInputDTO taskInputDTO, Long id);
}
