package com.example.rest_demo.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rest_demo.entity.Task;
import com.example.rest_demo.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 * @since 2021/11/16 22:48
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    public void create(Task task) {
        int ret = baseMapper.insert(task);
        System.out.println("create: " + task + "result:" + ret);
    }

    public void update(Task task) {
        int ret = baseMapper.updateById(task);
        System.out.println("update: " + task + "result:" + ret);
    }

    public void delete(Long id) {
        int ret = baseMapper.deleteById(id);
        System.out.println("delete: " + id + "result:" + ret);
    }

    public Task retrieve(Long id) {
        System.out.println("get: " + id);
        Task task = baseMapper.selectById(id);
        return task;
    }
}
