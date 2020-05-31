package com.springboot.service;

//import com.springboot.domain.TaskComment;
import com.springboot.domain.Comment;
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

    //List<Comment> getAllTaskComment();

    Comment queryTaskCommentById(String id);

    //List<Comment> queryTaskCommentByUserId(String user_id);

    //List<Comment> queryTaskCommentByTableId(String table_id);

    List<Comment> select(int choice, String id);

    int insertTaskComment(Comment taskComment);

    //int updateTaskCommentContent(@Param("content") String content, @Param("id") String id);

    //int updateTaskCommentThumb(String id);

    //int updateTaskCommentComment(String id);

    int update(int choice, @Param("content") String content, @Param("id") String id);

    int deleteTaskComment(String id);

}
