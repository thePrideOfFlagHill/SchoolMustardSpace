package com.springboot.controller;

import com.springboot.constant.TaskConstant;
import com.springboot.domain.Task;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TaskController
 * TODO
 * @description 所有的TaskController请求的接口
 * 1./api/task/query/all                查询全部任务用接口
 * 2./api/task/query/id/{id}            根据条目id查询任务（单个对应）
 * 3./api/task/query/user_id/{user_id}  根据用户id查询任务（多个对应）
 * 4./api/task/query/like/title         标题的模糊查找
 * 5./api/task/query/like/content       内容的模糊查找
 * 6./api/task/query/like/label         标签的模糊查找
 * 7./api/task/insert                   发布任务用接口 post为一个json整体 成功返回当前添加的任务的条目id 用于下一个接口更新图片的地址
 * 8./api/task/update                   更新任务基本信息用接口 post为一个json整体对应任务实体domian
 * 9./api/task/update/is_done           更新任务的解决状态用接口 更新修改任务的解决状态 键值对为二 key = id && is_done 0:未解决 1：已解决
 * 10./api/task/update/thumb_up         更新任务的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 11./api/task/update/collect          更新任务的收藏+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 12./api/task/update/comment          更新任务的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 13./api/task/delete                  删除任务用接口 删除任务用接口 键值对为一 key = id
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController implements TaskConstant {

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
    @GetMapping("task/query/all")
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
    @GetMapping("task/query/id/{id}")
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
    @GetMapping("task/query/user_id/{user_id}")
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
//    @RequestMapping(value = "task/query/like/title/{title}", method = RequestMethod.GET)
    @GetMapping("task/query/like/title")
    public JsonResult queryTaskLikeContent(@Param("title")String title) {

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
//    @RequestMapping(value = "task/query/like/content/{content}", method = RequestMethod.GET)
    @GetMapping("task/query/like/content")
    public JsonResult queryTaskLikeTitle(@Param("content")String content) {

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
//    @RequestMapping(value = "task/query/like/label/{label}", method = RequestMethod.GET)
    @GetMapping("task/query/like/label")
    public JsonResult queryTaskLikeLabel(@Param("label") String label) {

        List<Task> list = this.taskService.getLikeLabel(label);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * insertTask
     * TODO
     * @description /api/task/insert 发布任务用接口 post为一个json整体 成功返回当前添加的任务的条目id 用于下一个接口更新图片的地址
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
   @PostMapping(value = "task/insert")
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
   @PostMapping(value = "task/update")
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
   @PostMapping(value = "task/update/is_done")
    public JsonResult updateTaskDone(@RequestBody Map<String, String> map) {

        int temp = taskService.updateTaskIs_done(Integer.parseInt(map.get("is_done")),map.get("id"));

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
   @PostMapping(value = "task/update/thumb_up")
    public JsonResult updateTaskThump(@RequestBody Map<String, String> map) {


        int temp = taskService.updateTaskThumb(map.get("id"));

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
   @PostMapping(value = "task/update/collect")
    public JsonResult updateTaskCollect(@RequestBody Map<String, String> map) {


        int temp = taskService.updateTaskCollect(map.get("id"));

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
   @PostMapping(value = "task/update/comment")
    public JsonResult updateTaskComment(@RequestBody Map<String, String> map) {


        int temp = taskService.updateTaskComment(map.get("id"));

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
   @PostMapping(value = "task/delete")
    public JsonResult deleteTask(@RequestBody Map<String, String> map) {


        int temp = taskService.deleteTask(map.get("id"));

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }
}
