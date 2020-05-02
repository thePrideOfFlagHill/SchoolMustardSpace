package com.springboot.service.Impl;

import com.springboot.domain.Task;
import com.springboot.mapper.TaskCommentMapper;
import com.springboot.mapper.TaskMapper;
import com.springboot.service.TaskCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskCommentServiceImpl
 * TODO
 * @description TaskCommentServiceImpl 服务实现层
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
@Service
public class TaskCommentServiceImpl implements TaskCommentService {

    @Autowired
    private TaskCommentMapper taskCommentMapper;

    @Override
    public List<Task> getAllTaskComment() {

        List<Task> list = this.taskCommentMapper.getAllTaskComment();

        return list;

    }

    @Override
    public Task queryTaskCommentById(String id){

        Task task = this.taskCommentMapper.queryTaskCommentById(id);

        return task;
    }

    @Override
    public List<Task> queryTaskCommentByUserId(String user_id){

        List<Task> list = this.taskCommentMapper.queryTaskCommentByUserId(user_id);

        return list;
    }

    @Override
    public List<Task> queryTaskCommentByTableId(String table_id){

        List<Task> list = this.taskCommentMapper.queryTaskCommentByTableId(table_id);

        return list;
    }

}
    