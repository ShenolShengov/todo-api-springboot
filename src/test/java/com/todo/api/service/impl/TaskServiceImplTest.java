package com.todo.api.service.impl;

import com.todo.api.model.dto.TaskInfoDTO;
import com.todo.api.model.entity.TaskEntity;
import com.todo.api.model.enumeration.TaskStatus;
import com.todo.api.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskServiceImplTest {


   private final TaskServiceImpl toTest;
   private final TaskRepository taskRepository =  mock(TaskRepository.class);

    public TaskServiceImplTest() {
        toTest = new TaskServiceImpl(taskRepository, new ModelMapper());
    }

    private TaskEntity createTaskEntity(String title) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(title);
        taskEntity.setDescription("desc");
        taskEntity.setDueDate(LocalDateTime.now());
        taskEntity.setTaskStatus(TaskStatus.IN_PROGRESS);
        return taskEntity;
    }



    @Test
    public void testGetAll() {
        //Arrange
        when(taskRepository.findAll()).thenReturn(List.of(createTaskEntity("Java work"),
                createTaskEntity("Write tests")));

        //Act
        List<TaskInfoDTO> all = toTest.getAll();

        //Assert
        assertEquals(3, all.size());

        assertTrue(all.stream().anyMatch(t -> t.getTitle().equals("Java work")));
    }
}