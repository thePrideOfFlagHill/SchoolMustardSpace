package com.springboot.controller;

import com.springboot.constant.TaskConstant;
import com.springboot.domain.Task;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * PostController
 * TODO
 * @description 所有的post请求的接口
 * 1./api/task/insert 发布任务用接口 post为一个json整体 成功返回当前添加的任务的条目id 用于下一个接口更新图片的地址
 * 2./api/task/update 更新任务基本信息用接口 post为一个json整体对应任务实体domian
 * 3./api/task/update/is_done 更新任务的解决状态用接口 更新修改任务的解决状态 键值对为二 key = id && is_done 0:未解决 1：已解决
 * 4./api/task/update/thumb_up 更新任务的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 5./api/task/update/collect 更新任务的收藏+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 6./api/task/update/comment 更新任务的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 7./api/task/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskPostController implements TaskConstant {

    @Autowired
    private TaskService taskService;

    /**
     * insertTask
     * TODO
     * @description /api/task/insert 发布任务用接口 post为一个json整体 成功返回当前添加的任务的条目id 用于下一个接口更新图片的地址
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/insert", method = RequestMethod.POST)
    public JsonResult insertTask(@RequestBody Task task) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        //发布初始化
        task.setId(uuidResult.setUuidResult());
        task.setIs_done(INIT_DONE);
        task.setThumb_up(INIT_THUMB);
        task.setCollect(INIT_COLLECT);
        task.setComment(INIT_COMMENT);

        int temp = taskService.insertTask(task);

        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.ok(task.getId());
    }

    /**
     * updateTask
     * TODO
     * @description /api/task/update 更新任务基本信息用接口 post为一个json整体对应任务实体domian
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/update", method = RequestMethod.POST)
    public JsonResult updateTask(@RequestBody Task task) {

        int temp = taskService.updateTask(task);

        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.ok(task);
    }


    /**
     * updateTaskDone
     * TODO
     * @description /api/task/update/is_done 更新任务的解决状态用接口 更新修改任务的解决状态 键值对为二 key = id && is_done 0:未解决 1：已解决
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/update/is_done", method = RequestMethod.POST)
    public JsonResult updateTaskDone(@RequestParam(value = "id") String id,
                                     @RequestParam(value = "is_done") int id_done) {


        int temp = taskService.updateTaskIs_done(id_done,id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * updateTaskThump
     * TODO
     * @description /api/task/update/thumb_up 更新任务的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/update/thumb_up", method = RequestMethod.POST)
    public JsonResult updateTaskThump(@RequestParam(value = "id") String id) {


        int temp = taskService.updateTaskThumb(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,null);

    }

    /**
     * updateTaskCollect
     * TODO
     * @description /api/task/update/collect 更新任务的收藏+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/update/collect", method = RequestMethod.POST)
    public JsonResult updateTaskCollect(@RequestParam(value = "id") String id) {


        int temp = taskService.updateTaskCollect(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * updateTaskComment
     * TODO
     * @description /api/task/update/comment 更新任务的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/update/comment", method = RequestMethod.POST)
    public JsonResult updateTaskComment(@RequestParam(value = "id") String id) {


        int temp = taskService.updateTaskComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * deleteTask
     * TODO
     * @description /api/task/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/delete", method = RequestMethod.POST)
    public JsonResult deleteTask(@RequestParam(value = "id") String id) {


        int temp = taskService.deleteTask(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }


}
