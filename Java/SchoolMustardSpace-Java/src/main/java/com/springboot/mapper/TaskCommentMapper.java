package com.springboot.mapper;

import com.springboot.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TaskMapper
 * TODO
 * @description TaskMapper
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
@Mapper
public interface TaskCommentMapper {

    //查询全部
    @Select("select * from task_comment")
    List<Task> getAllTaskComment();

    //根据条目id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE id =#{id}")
    Task queryTaskCommentById(String id);

    //按上传者的owner_id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE user_id =#{user_id}")
    List<Task> queryTaskCommentByUserId(String user_id);

    //按任务表的table_id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE table_id =#{table_id}")
    List<Task> queryTaskCommentByTableId(String table_id);


}
    