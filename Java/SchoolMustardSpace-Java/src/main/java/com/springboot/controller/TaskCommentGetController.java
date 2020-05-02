package com.springboot.controller;

import com.springboot.domain.Task;
import com.springboot.mapper.TaskCommentMapper;
import com.springboot.service.TaskCommentService;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/task/comment/query/all 查询全部任评论用接口
 * 2./api/task/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
 * 3./api/task/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/task/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskCommentGetController {

    @Autowired
    private TaskCommentService taskCommentService;

    /**
     * queryTaskCommentAll
     * TODO
     * @description /api/task/comment/query/all 查询全部任评论用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @RequestMapping(value = "task/comment/query/all", method = RequestMethod.GET)
    public JsonResult queryTaskCommentAll() {

        List<Task> list = this.taskCommentService.getAllTaskComment();

        return JsonResult.ok(list);

    }

    /**
     * queryTaskById
     * TODO
     * @description /api/task/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @RequestMapping(value = "query/task/comment/id/{id}", method = RequestMethod.GET)
    public JsonResult queryTaskCommentById(@PathVariable String id) {

        Task task = this.taskCommentService.queryTaskCommentById(id);

        return JsonResult.ok(task);

    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @RequestMapping(value = "query/task/comment/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryTaskCommentByUserId(@PathVariable String user_id) {

        List<Task> list = this.taskCommentService.queryTaskCommentByUserId(user_id);

        return JsonResult.ok(list);

    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @RequestMapping(value = "query/task/comment/table_id/{table_id}", method = RequestMethod.GET)
    public JsonResult queryTaskCommentByTableId(@PathVariable String table_id) {

        List<Task> list = this.taskCommentService.queryTaskCommentByTableId(table_id);

        return JsonResult.ok(list);

    }
}
    