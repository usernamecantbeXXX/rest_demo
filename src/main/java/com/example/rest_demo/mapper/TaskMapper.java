package com.example.rest_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rest_demo.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xxx
 * @since 2021/11/17 0:13
 */
@Mapper
@Repository
public interface TaskMapper extends BaseMapper<Task> {
}
