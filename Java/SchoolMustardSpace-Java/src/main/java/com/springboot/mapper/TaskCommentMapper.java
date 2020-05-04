package com.springboot.mapper;

import com.springboot.domain.TaskComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TaskCommentMapper
 * TODO
 * @description TaskCommentMapper
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
@Mapper
public interface TaskCommentMapper {

    //查询全部
    @Select("select * from task_comment")
    List<TaskComment> getAllTaskComment();

    //根据条目id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE id =#{id}")
    TaskComment queryTaskCommentById(String id);

    //按上传者的owner_id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE user_id =#{user_id}")
    List<TaskComment> queryTaskCommentByUserId(String user_id);

    //按任务表的table_id查询具体任务评论
    @Select("SELECT * FROM task_comment WHERE table_id =#{table_id}")
    List<TaskComment> queryTaskCommentByTableId(String table_id);

    //发布插入任务评论
    @Insert("INSERT INTO task_comment (id, user_id, content, publish_time, table_id, thumb_up, comment) "
            + "VALUES (#{id}, #{user_id}, #{content}, #{publish_time}, #{table_id}, #{thumb_up}, #{comment})")
    int insertTaskComment(TaskComment taskComment);

    //更新任务评论内容
    @Update("UPDATE task_comment SET `content`=#{content} WHERE id=#{id}")
    int updateTaskCommentContent(@Param("content") String content, @Param("id") String id);

    //更新任务 点赞数+1
    @Update("UPDATE task_comment SET thumb_up = thumb_up + 1 WHERE id=#{id}")
    int updateTaskCommentThumb(String id);

    //更新任务 评论数+1
    @Update("UPDATE task_comment SET comment = comment + 1 WHERE id=#{id}")
    int updateTaskCommentComment(String id);

    //删除任务
    @Delete("delete from task_comment where id = #{id}")
    int deleteTaskComment(String id);


}
    