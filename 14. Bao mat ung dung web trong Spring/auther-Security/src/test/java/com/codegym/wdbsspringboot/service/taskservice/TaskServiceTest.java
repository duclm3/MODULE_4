package com.codegym.wdbsspringboot.service.taskservice;

import com.codegym.wdbsspringboot.model.Task;
import com.codegym.wdbsspringboot.repository.ITaskRepository;
//import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private ITaskRepository taskRepository = Mockito.mock(ITaskRepository.class);

    private ITaskService taskService = new TaskService(taskRepository);

    @BeforeEach
    void init(){
        Task task = new Task();
        task.setName("Mua sua cho con");
        task.setDescription("500");
        task.setId(1L);
        List<Task> taskList = Arrays.asList(task);
        doReturn(taskList).when(taskRepository).findAll();
    }

    @Test
    @DisplayName("findAll can return a list has 1 element")
    public void whenCallFindAll_thenReturnListTaskHasOneElement(){
        Iterable<Task> tasks = taskService.findAll();
        assertThat(tasks).hasSize(1);
    }


    @Test
    @DisplayName("create can return a 1 element")
    public void whenCallCreate_ThenReturnTask(){
        //arrange
        Task task = new Task();
        task.setName("Mua quan ao cho con");
        task.setDescription("200");
        //action
        taskService.save(task);
        // assert
        verify(taskRepository, times(1)).save(task);
    }


}