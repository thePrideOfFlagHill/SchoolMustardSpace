package com.springboot.service;

import com.springboot.domain.Task;

import java.util.List;

/**
 * TaskService
 * TODO
 * @description 数据服务层 TaskService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
public interface TaskService {

    List<Task> getAllTask();

    Task queryTaskById(String id);

    List<Task> queryTaskByUserId(String user_id);

}
