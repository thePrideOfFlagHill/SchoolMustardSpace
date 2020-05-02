package com.springboot.service;

import com.springboot.domain.Task;

import java.util.List;

/**
 * TaskService
 * TODO
 * @description 数据服务层 TaskCommentService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
public interface TaskCommentService {

    List<Task> getAllTaskComment();

    Task queryTaskCommentById(String id);

    List<Task> queryTaskCommentByUserId(String user_id);

    List<Task> queryTaskCommentByTableId(String table_id);
}
