package com.example.rest_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rest_demo.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xxx
 * @since 2021/11/17 0:13
 */
@Mapper
@Repository
public interface TaskMapper extends BaseMapper<Task> {
//    List<Task> findByDueDate(@Param(value = "dueDate") String today);
}
