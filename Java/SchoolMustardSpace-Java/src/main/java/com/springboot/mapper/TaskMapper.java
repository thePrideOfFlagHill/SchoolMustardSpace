package com.springboot.mapper;

import com.springboot.domain.LostAndFound;
import com.springboot.domain.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TaskMapper
 * TODO
 * @description TaskMapper
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
@Mapper
public interface TaskMapper {

    //查询全部
    @Select("select * from task")
    List<Task> getAllTask();

    //根据条目id查询具体任务
    @Select("SELECT * FROM task WHERE id =#{id}")
    Task queryTaskById(String id);

    //按上传者的owner_id查询具体任务
    @Select("SELECT * FROM task WHERE user_id =#{user_id}")
    List<Task> queryTaskByUserId(String user_id);

    //模糊查询内容
    @Select("select * from task where content like concat('%' , #{text} , '%')")
    List<Task> getLikeContent(@Param("text") String text);

    //模糊查询标题
    @Select("select * from task where title like concat('%' , #{text} , '%')")
    List<Task> getLikeTitle(@Param("text") String text);

    //模糊查询标签
    @Select("select * from task where label like concat('%' , #{text} , '%')")
    List<Task> getLikeLabel(@Param("text") String text);

    //发布插入任务
    @Insert("INSERT INTO task (id, user_id, title, content, image, label, location, is_done, reword, start_time, end_time, thumb_up, collect, comment) "
            + "VALUES (#{id}, #{user_id}, #{title}, #{content}, #{image}, #{label}, #{location}, #{is_done}, #{reword}, #{start_time}, #{end_time}, #{thumb_up}, #{collect}, #{comment})")
    int insertTask(Task task);

    //更新任务信息
    @Update("UPDATE task SET " +
            "user_id=#{user_id}, " +
            "title=#{title}, " +
            "content=#{content}, " +
            "image=#{image}, " +
            "label=#{label}, " +
            "location=#{location}, " +
            "is_done=#{is_done}, " +
            "reword=#{reword}, " +
            "start_time=#{start_time}, " +
            "end_time=#{end_time}, " +
            "thumb_up=#{thumb_up}, " +
            "collect=#{collect}, " +
            "comment=#{comment} " +
            "WHERE id=#{id}")
    int updateTask(Task task);

    //更新任务解决状态
    @Update("UPDATE task SET `is_done`=#{is_done} WHERE id=#{id}")
    int updateTaskIs_done(@Param("is_done") int is_done, @Param("id") String id);

    //更新任务 点赞数+1
    @Update("UPDATE task SET thumb_up = thumb_up + 1 WHERE id=#{id}")
    int updateTaskThumb(String id);

    //更新任务 收藏数+1
    @Update("UPDATE task SET collect = collect + 1 WHERE id=#{id}")
    int updateTaskCollect(String id);

    //更新任务 评论数+1
    @Update("UPDATE task SET comment = comment + 1 WHERE id=#{id}")
    int updateTaskComment(String id);

    //更新图片url地址
    @Update("UPDATE task SET `image`=#{image} WHERE id=#{id}")
    int updateTaskImageUrl(@Param("image") String image, @Param("id") String id);

    //删除任务
    @Delete("delete from task where id = #{id}")
    int deleteTask(String id);

}
    