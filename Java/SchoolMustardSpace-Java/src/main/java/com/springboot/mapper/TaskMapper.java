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
}
    