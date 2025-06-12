package com.todo.api.service;


import com.todo.api.model.dto.TaskInfoDTO;

import java.util.List;

public interface TaskService {

    List<TaskInfoDTO> getAll();
}
