package com.springboot.controller;

import com.springboot.constant.FoundCommentConstant;
//import com.springboot.domain.LostFoundComment;
import com.springboot.domain.Comment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.LostFoundCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TaskCommentGetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/lostfound/comment/query/all 查询全部任评论用接口
 * 2./api/lostfound/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
 * 3./api/lostfound/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/lostfound/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LostFoundCommentGetController implements FoundCommentConstant {

    @Autowired
    private LostFoundCommentService lostFoundCommentService;
    @Autowired
    private UserService userService;


    /**
     * queryLostFoundCommentAll
     * TODO
     * @description /api/lostfound/comment/query/all 查询全部任评论用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "lostfound/comment/query/all", method = RequestMethod.GET)
    public JsonResult queryLostFoundCommentAll() {

        List<Comment> list = this.lostFoundCommentService.getAllLostFoundComment();

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryLostFoundCommentById
     * TODO
     * @description /api/lostfound/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
     * @author 221701412_theTuring  会飞的大野鸡
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/lostfound/comment/id/{id}", method = RequestMethod.GET)
    public JsonResult queryLostFoundCommentById(@PathVariable String id) {

        Comment lostFoundComment = this.lostFoundCommentService.queryLostFoundCommentById(id);

        CommentPlus commentPlus = new CommentPlus();
        User user = userService.queryOneUserById(id);

        commentPlus.setId(lostFoundComment.getId());
        commentPlus.setUser_id(lostFoundComment.getUser_id());
        commentPlus.setContent(lostFoundComment.getContent());
        commentPlus.setPublish_time(lostFoundComment.getPublish_time());
        commentPlus.setComment(lostFoundComment.getComment());
        commentPlus.setThumb_up(lostFoundComment.getThumb_up());
        commentPlus.setTable_id(lostFoundComment.getTable_id());
        commentPlus.setName(user.getName());

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,commentPlus);

    }

    /**
     * queryLostFoundCommentByUserId
     * TODO
     * @description /api/lostfound/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/lostfound/comment/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryLostFoundCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.lostFoundCommentService.queryLostFoundCommentByUserId(user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryLostFoundCommentByTableId
     * TODO
     * @description /api/lostfound/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/lostfound/comment/table_id/{table_id}", method = RequestMethod.GET)
    public JsonResult queryLostFoundCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.lostFoundCommentService.queryLostFoundCommentByTableId(table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }
}
