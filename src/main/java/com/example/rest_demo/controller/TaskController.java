package com.example.rest_demo.controller;

import com.example.rest_demo.Service.TaskService;
import com.example.rest_demo.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String create(@ModelAttribute Task task) {
        String ret = taskService.create(task) == 1 ? "SUCCESS" : "FAILED";
        log.info("create: " + task);
        return ret;
    }

    /**
     * Update a Task, providing the entire Resource
     */
    @PutMapping()
    public String update(@RequestBody Task task) {
        String ret = taskService.update(task) == 1 ? "SUCCESS" : "FAILED";
        log.info("update: " + task);
        return ret;
    }

    /**
     * Remove a Task
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        String ret = taskService.delete(id) == 1 ? "SUCCESS" : "FAILED";
        log.info("delete: " + id);
        return ret;
    }

    /**
     * Retrieve a specific Task, or a listing of Tasks.
     */
    @GetMapping()
    @ResponseBody
    public List<Task> retrieve(@RequestParam(required = false) String expiredToday) {
        log.info("retrieve: " + expiredToday);
        return taskService.retrieve(expiredToday);
    }

}
