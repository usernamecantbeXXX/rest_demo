package com.example.rest_demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rest_demo.entity.Task;

/**
 * @author xxx
 * @since 2021/11/16 21:57
 */
public interface TaskService extends IService<Task> {

    void create(Task task);

    void update(Task task);

    void delete(Long id);

    Task retrieve(Long id);
}
