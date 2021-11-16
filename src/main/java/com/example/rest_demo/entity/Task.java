package com.example.rest_demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author xxx
 * @since 2021/11/16 21:20
 */
@Data
@EqualsAndHashCode
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("d_task")
public class Task {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String title;
    private String dueDate;
    private String status;
    @Version
    @TableField(fill= FieldFill.INSERT)
    private int version;
}
