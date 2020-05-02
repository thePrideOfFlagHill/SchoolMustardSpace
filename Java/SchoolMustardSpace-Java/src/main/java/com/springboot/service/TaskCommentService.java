package com.springboot.service;

import com.springboot.domain.TaskComment;
import org.apache.ibatis.annotations.Param;

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

    List<TaskComment> getAllTaskComment();

    TaskComment queryTaskCommentById(String id);

    List<TaskComment> queryTaskCommentByUserId(String user_id);

    List<TaskComment> queryTaskCommentByTableId(String table_id);

    int insertTaskComment(TaskComment taskComment);

    int updateTaskCommentContent(@Param("content") String content, @Param("id") String id);

    int updateTaskCommentThumb(String id);

    int updateTaskCommentComment(String id);

    int deleteTaskComment(String id);

}
