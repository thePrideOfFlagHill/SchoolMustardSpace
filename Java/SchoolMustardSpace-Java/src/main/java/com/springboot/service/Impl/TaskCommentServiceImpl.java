package com.springboot.service.Impl;

//import com.springboot.domain.TaskComment;
import com.springboot.domain.Comment;
import com.springboot.mapper.TaskCommentMapper;
import com.springboot.service.TaskCommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskCommentServiceImpl
 * TODO
 * @description TaskCommentServiceImpl 服务实现层
 * @author 221701412_theTuring  会飞的大野鸡
 * @version v 1.0.0
 * @since 2020.4.30
 */
@Service
public class TaskCommentServiceImpl implements TaskCommentService {

    @Autowired
    private TaskCommentMapper taskCommentMapper;

    @Override
    public List<Comment> getAllTaskComment() {

        List<Comment> list = this.taskCommentMapper.getAllTaskComment();

        return list;

    }

    @Override
    public Comment queryTaskCommentById(String id){

        Comment taskComment = this.taskCommentMapper.queryTaskCommentById(id);

        return taskComment;
    }

    @Override
    public List<Comment> queryTaskCommentByUserId(String user_id){

        List<Comment> list = this.taskCommentMapper.queryTaskCommentByUserId(user_id);

        return list;
    }

    @Override
    public List<Comment> queryTaskCommentByTableId(String table_id){

        List<Comment> list = this.taskCommentMapper.queryTaskCommentByTableId(table_id);

        return list;
    }

    @Override
    public int insertTaskComment(Comment taskComment){

        int temp = this.taskCommentMapper.insertTaskComment(taskComment);

        return temp;

    }

    @Override
    public int updateTaskCommentContent(@Param("content") String content, @Param("id") String id){

        int temp = this.taskCommentMapper.updateTaskCommentContent(content,id);

        return temp;
    }

    @Override
    public int updateTaskCommentThumb(String id){

        int temp = this.taskCommentMapper.updateTaskCommentThumb(id);

        return temp;
    }

    @Override
    public int updateTaskCommentComment(String id){

        int temp = this.taskCommentMapper.updateTaskCommentComment(id);

        return temp;
    }

    @Override
    public int deleteTaskComment(String id){

        int temp = this.taskCommentMapper.deleteTaskComment(id);

        return temp;
    }

}
