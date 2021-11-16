package com.example.rest_demo.controller;

import com.example.rest_demo.Service.TaskService;
import com.example.rest_demo.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xxx
 * @since 2021/11/16 20:28
 */
@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Create a new Task
     */
    @PostMapping()
    public void create(@RequestBody Task task) {
        taskService.create(task);
        log.info("create: " + task);
//        System.out.println("tasks add" + title + " 21/08/2019");
    }

    /**
     * Update a Task, providing the entire Resource
     */
    @PutMapping()
    public void update(@RequestBody Task task) {
        taskService.update(task);
        log.info("update: " + task);
    }

    /**
     * Remove a Task
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
        log.info("delete: " + id);
    }

    /**
     * Retrieve a specific Task, or a listing of Tasks.
     */
    @GetMapping("/{id}")
    public Task retrieve(@PathVariable Long id) {
        System.out.println("con get");
        log.info("retrieve: " + id);
        return taskService.retrieve(id);
    }

}
