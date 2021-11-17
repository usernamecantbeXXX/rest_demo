package com.example.rest_demo.Service;

import com.example.rest_demo.entity.Task;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Order(1)
    @Test
    void create() {
        Task task = new Task(2, "title", "17/11/2021", "todo");
        assertEquals(taskService.create(task), 1);
    }

    @Order(2)
    @Test
    void update() {
        Task task = new Task(2, "put to 2", "17/11/2021", "todo");
        assertEquals(taskService.update(task), 1);
    }

    @Order(3)
    @Test
    void delete() {
        assertEquals(taskService.delete(2), 1);
    }

    @Test
    void retrieveAll() {
        Assertions.assertNotNull(taskService.retrieve(null));
    }

    @Test
    void retrieveExpiredToday() {
        String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        taskService.retrieve("--expiring-today").forEach(task -> assertEquals(today, task.getDueDate()));
    }
}


