package com.springboot.controller;

import com.springboot.constant.TaskCommentConstant;
import com.springboot.domain.Comment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.TaskCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TaskCommentController
 * TODO
 * @description 所有的TaskCommentController请求的接口
 * 1./api/task/comment/query/all 查询全部任评论用接口
 * 2./api/task/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
 * 3./api/task/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/task/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
 * 5./api/task/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
 * 6./api/task/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 7./api/task/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 8./api/task/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 9./api/task/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskCommentController implements TaskCommentConstant {
    @Autowired
    private TaskCommentService taskCommentService;
    @Autowired
    private UserService userService;

    /**
     * queryTaskCommentAll
     * TODO
     * @description /api/task/comment/query/all 查询全部任评论用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @GetMapping("task/comment/query/all")
    public JsonResult queryTaskCommentAll() {

        List<Comment> list = this.taskCommentService.select(1, null);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * queryTaskById
     * TODO
     * @description /api/task/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @GetMapping("query/task/comment/id/{id}")
    public JsonResult queryTaskCommentById(@PathVariable String id) {

        Comment taskComment = this.taskCommentService.queryTaskCommentById(id);

        CommentPlus commentPlus = new CommentPlus();
        User user = userService.queryOneUserById(id);

        commentPlus.setId(taskComment.getId());
        commentPlus.setUser_id(taskComment.getUser_id());
        commentPlus.setContent(taskComment.getContent());
        commentPlus.setPublish_time(taskComment.getPublish_time());
        commentPlus.setComment(taskComment.getComment());
        commentPlus.setThumb_up(taskComment.getThumb_up());
        commentPlus.setTable_id(taskComment.getTable_id());
        commentPlus.setName(user.getName());

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,commentPlus);
    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring 会飞的大野鸡
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @GetMapping("query/task/comment/user_id/{user_id}")
    public JsonResult queryTaskCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.taskCommentService.select(2, user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * queryTaskByUserId
     * TODO
     * @description /api/task/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @GetMapping("query/task/comment/table_id/{table_id}")
    public JsonResult queryTaskCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.taskCommentService.select(3, table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * insertTask
     * TODO
     * @description /api/task/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.30
     */
    @PostMapping("task/comment/insert")
    public JsonResult insertTaskComment(@RequestBody Comment taskComment) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        DateResult dateResult = new DateResult();

        //发布初始化
        taskComment.setId(uuidResult.setUuidResult());
        taskComment.setPublish_time(dateResult.getCurrentTime());

        String context = taskComment.getContent();
        taskComment.setContent(WordController.wordSeeker.replaceWords(context));


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
    @PostMapping("task/comment/update/content")
    public JsonResult updateTaskCommentContent(@RequestParam(value = "id") String id,
                                               @RequestParam(value = "content") String content) {

        int temp = taskCommentService.update(1, content, id);

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
    @PostMapping("task/comment/update/thumb_up")
    public JsonResult updateTaskCommentThump(@RequestParam(value = "id") String id) {

        int temp = taskCommentService.update(2, null, id);

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
    @PostMapping("task/comment/update/comment")
    public JsonResult updateTaskCommentComment(@RequestParam(value = "id") String id) {

        int temp = taskCommentService.update(3, null, id);

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
    @PostMapping("task/comment/delete")
    public JsonResult deleteTaskComment(@RequestParam(value = "id") String id) {

        int temp = taskCommentService.deleteTaskComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }
}
