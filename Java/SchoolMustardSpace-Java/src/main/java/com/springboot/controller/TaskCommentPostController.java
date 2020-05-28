package com.springboot.controller;

import com.springboot.constant.TaskCommentConstant;
//import com.springboot.domain.TaskComment;
import com.springboot.domain.Comment;
import com.springboot.service.TaskCommentService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TaskCommentPostController
 * TODO
 * @description 所有的post请求的接口
 * 1./api/task/comment/insert 发布任务用接口 post为一个json整体对应任务实体domain
 * 2./api/task/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 3./api/task/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 4./api/task/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 5./api/task/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskCommentPostController implements TaskCommentConstant {

    @Autowired
    private TaskCommentService taskCommentService;

    /**
     * insertTask
     * TODO
     * @description /api/task/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @RequestMapping(value = "task/comment/insert", method = RequestMethod.POST)
    public JsonResult insertTaskComment(@RequestBody Comment taskComment) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        DateResult dateResult = new DateResult();

        //发布初始化
        taskComment.setId(uuidResult.setUuidResult());
        taskComment.setPublish_time(dateResult.getCurrentTime());
        taskComment.setThumb_up(INIT_THUMB);
        taskComment.setComment(INIT_COMMENT);

        int temp = taskCommentService.insertTaskComment(taskComment);

        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }

    /**
     * updateTaskDone
     * TODO
     * @description /api/task/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/comment/update/content", method = RequestMethod.POST)
    public JsonResult updateTaskCommentContent(@RequestParam(value = "id") String id,
                                               @RequestParam(value = "content") String content) {


        int temp = taskCommentService.updateTaskCommentContent(content,id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * updateTaskThump
     * TODO
     * @description /api/task/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/comment/update/thumb_up", method = RequestMethod.POST)
    public JsonResult updateTaskCommentThump(@RequestParam(value = "id") String id) {


        int temp = taskCommentService.updateTaskCommentThumb(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,null);

    }

    /**
     * updateTaskComment
     * TODO
     * @description /api/task/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/comment/update/comment", method = RequestMethod.POST)
    public JsonResult updateTaskCommentComment(@RequestParam(value = "id") String id) {


        int temp = taskCommentService.updateTaskCommentComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * deleteTask
     * TODO
     * @description /api/task/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.29
     */
    @RequestMapping(value = "task/comment/delete", method = RequestMethod.POST)
    public JsonResult deleteTaskComment(@RequestParam(value = "id") String id) {


        int temp = taskCommentService.deleteTaskComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }


}
