package com.springboot.controller;

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
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class GetController {

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

        return JsonResult.ok(list);

    }

    /**
     * queryTaskById
     * TODO
     * @description /api/task/query/id/{id} 根据条目id查询任务（单个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "query/task/id/{id}", method = RequestMethod.GET)
    public JsonResult queryTaskById(@PathVariable String id) {

        Task task = this.taskService.queryTaskById(id);

        return JsonResult.ok(task);

    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "query/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryTaskByUserId(@PathVariable String user_id) {

        List<Task> list = this.taskService.queryTaskByUserId(user_id);

        return JsonResult.ok(list);

    }

}
