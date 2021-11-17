package com.example.rest_demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rest_demo.entity.Task;

import java.util.List;

/**
 * @author xxx
 * @since 2021/11/16 21:57
 */
public interface TaskService extends IService<Task> {

    int create(Task task);

    int update(Task task);

    int delete(Integer id);

    List<Task> retrieve(String expiredToday);
}
