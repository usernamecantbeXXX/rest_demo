package com.example.rest_demo.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rest_demo.entity.Task;
import com.example.rest_demo.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xxx
 * @since 2021/11/16 22:48
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public int create(Task task) {
        int ret = baseMapper.insert(task);
        System.out.println("create: " + task + "result:" + ret);
        return ret;
    }

    public int update(Task task) {
        int ret = baseMapper.updateById(task);
        System.out.println("update: " + task + "result:" + ret);
        return ret;
    }

    public int delete(Integer id) {
        int ret = baseMapper.deleteById(id);
        System.out.println("delete: " + id + "result:" + ret);
        return ret;
    }

    public List<Task> retrieve(String expiredToday) {
        System.out.println("get: " + expiredToday);
        List<Task> tasks;
        if ("--expiring-today".equals(expiredToday)) {
            String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            QueryWrapper<Task> wrapper = new QueryWrapper<>();
            wrapper.eq("due_date", today);
            tasks = baseMapper.selectList(wrapper);
        } else {
            tasks = list();
        }
        return tasks;
    }
}
