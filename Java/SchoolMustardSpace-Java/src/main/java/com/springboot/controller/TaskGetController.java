package com.springboot.controller;

import com.springboot.constant.TaskConstant;
import com.springboot.domain.Task;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/task/query/all 查询全部任务用接口
 * 2./api/task/query/id/{id} 根据条目id查询任务（单个对应）
 * 3./api/task/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/task/query/like/title  标题的模糊查找
 * 5./api/task/query/like/content 内容的模糊查找
 * 6./api/task/query/like/label  标签的模糊查找
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskGetController implements TaskConstant {

    @Autowired
    private TaskService taskService;

    /**
     * queryTaskAll
     * TODO
     * @description /api/task/query/all 查询全部任务用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "task/query/all", method = RequestMethod.GET)
    public JsonResult queryTaskAll() {

        List<Task> list = this.taskService.getAllTask();

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryTaskById
     * TODO
     * @description /api/task/query/id/{id} 根据条目id查询任务（单个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "task/query/id/{id}", method = RequestMethod.GET)
    public JsonResult queryTaskById(@PathVariable String id) {

        Task task = this.taskService.queryTaskById(id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,task);

    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "task/query/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryTaskByUserId(@PathVariable String user_id) {

        List<Task> list = this.taskService.queryTaskByUserId(user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryTaskLikeContent
     * TODO
     * @description /api/task/query/like/title  标题的模糊查找
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/query/like/title/{title}", method = RequestMethod.GET)
    public JsonResult queryTaskLikeContent(@PathVariable String title) {

        List<Task> list = this.taskService.getLikeTitle(title);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryTaskLikeTitle
     * TODO
     * @description task/query/like/content 内容的模糊查找
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/query/like/content/{content}", method = RequestMethod.GET)
    public JsonResult queryTaskLikeTitle(@PathVariable String content) {

        List<Task> list = this.taskService.getLikeContent(content);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryTaskLikeLabel
     * TODO
     * @description /api/task/query/like/label  标签的模糊查找
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/query/like/label/{label}", method = RequestMethod.GET)
    public JsonResult queryTaskLikeLabel(@PathVariable String label) {

        List<Task> list = this.taskService.getLikeLabel(label);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

}
