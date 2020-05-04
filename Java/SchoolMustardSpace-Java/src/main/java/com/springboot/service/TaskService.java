package com.springboot.service;

import com.springboot.domain.Task;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    List<Task> getLikeContent(@Param("text") String text);

    List<Task> getLikeTitle(@Param("text") String text);

    List<Task> getLikeLabel(@Param("text") String text);

    int insertTask(Task task);

    int updateTask(Task task);

    int updateTaskIs_done(@Param("is_done") int is_done, @Param("id") String id);

    int updateTaskThumb(String id);

    int updateTaskCollect(String id);

    int updateTaskComment(String id);

    int updateTaskImageUrl(@Param("image") String image, @Param("id") String id);

    int deleteTask(String id);

}
