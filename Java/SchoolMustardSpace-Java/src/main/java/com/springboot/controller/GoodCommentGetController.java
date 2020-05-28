package com.springboot.controller;

import com.springboot.constant.GoodCommentConstant;
//import com.springboot.domain.GoodComment;
import com.springboot.domain.Comment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.GoodCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GoodCommentGetController
 * TODO
 * @description 所有的get请求的接口
 * 1./api/good/comment/query/all 查询全部任评论用接口
 * 2./api/good/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
 * 3./api/good/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/good/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GoodCommentGetController implements GoodCommentConstant {

    @Autowired
    private GoodCommentService goodCommentService;
    @Autowired
    private UserService userService;

    /**
     * queryGoodCommentAll
     * TODO
     * @description /api/good/comment/query/all 查询全部任评论用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "good/comment/query/all", method = RequestMethod.GET)
    public JsonResult queryGoodCommentAll() {

        List<Comment> list = this.goodCommentService.getAllGoodComment();

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryGoodCommentById
     * TODO
     * @description /api/good/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
     * @author 221701412_theTuring  会飞的大野鸡
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/good/comment/id/{id}", method = RequestMethod.GET)
    public JsonResult queryGoodCommentById(@PathVariable String id) {

        Comment goodComment = this.goodCommentService.queryGoodCommentById(id);

        CommentPlus commentPlus = new CommentPlus();
        User user = userService.queryOneUserById(id);

        commentPlus.setId(goodComment.getId());
        commentPlus.setUser_id(goodComment.getUser_id());
        commentPlus.setContent(goodComment.getContent());
        commentPlus.setPublish_time(goodComment.getPublish_time());
        commentPlus.setComment(goodComment.getComment());
        commentPlus.setThumb_up(goodComment.getThumb_up());
        commentPlus.setTable_id(goodComment.getTable_id());
        commentPlus.setName(user.getName());

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,commentPlus);

    }

    /**
     * queryGoodCommentByUserId
     * TODO
     * @description /api/good/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/good/comment/user_id/{user_id}", method = RequestMethod.GET)
    public JsonResult queryGoodCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.goodCommentService.queryGoodCommentByUserId(user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    /**
     * queryGoodCommentByTableId
     * TODO
     * @description /api/good/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/good/comment/table_id/{table_id}", method = RequestMethod.GET)
    public JsonResult queryGoodCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.goodCommentService.queryGoodCommentByTableId(table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }
}
