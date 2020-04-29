package com.springboot.service.Impl;

import com.springboot.domain.Task;
import com.springboot.mapper.TaskMapper;
import com.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskServiceImpl
 * TODO
 * @description TaskServiceImpl 服务实现层
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> getAllTask() {

        List<Task> list = this.taskMapper.getAllTask();

        return list;

    }

    @Override
    public Task queryTaskById(String id){

        Task task = this.taskMapper.queryTaskById(id);

        return task;
    }

    @Override
    public List<Task> queryTaskByUserId(String user_id){

        List<Task> list = this.taskMapper.queryTaskByUserId(user_id);

        return list;
    }



}
    