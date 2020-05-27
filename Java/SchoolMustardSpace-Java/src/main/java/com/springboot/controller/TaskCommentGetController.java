package com.springboot.controller;

import com.springboot.constant.TaskCommentConstant;
import com.springboot.domain.Comment;
//import com.springboot.domain.TaskComment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.TaskCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TaskCommentGetController
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
public class TaskCommentGetController implements TaskCommentConstant {

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
    @RequestMapping(value = "task/comment/query/all", method = RequestMethod.GET)
    public JsonResult queryTaskCommentAll() {

        List<Comment> list = this.taskCommentService.getAllTaskComment();

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
    @RequestMapping(value = "query/task/comment/id/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "query/task/comment/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryTaskCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.taskCommentService.queryTaskCommentByUserId(user_id);

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
    @RequestMapping(value = "query/task/comment/table_id/{table_id}", method = RequestMethod.GET)
    public JsonResult queryTaskCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.taskCommentService.queryTaskCommentByTableId(table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }
}
