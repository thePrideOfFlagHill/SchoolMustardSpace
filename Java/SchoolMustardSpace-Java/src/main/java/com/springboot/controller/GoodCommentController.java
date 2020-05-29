package com.springboot.controller;

import com.springboot.constant.GoodCommentConstant;
import com.springboot.domain.Comment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.GoodCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.springboot.constant.GoodCommentConstant.*;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GoodCommentController {
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

    @RequestMapping(value = "good/comment/insert", method = RequestMethod.POST)
    public JsonResult insertGoodComment(@RequestBody Comment goodComment) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        DateResult dateResult = new DateResult();

        //发布初始化
        goodComment.setId(uuidResult.setUuidResult());
        goodComment.setPublish_time(dateResult.getCurrentTime());
        goodComment.setThumb_up(INIT_THUMB);
        goodComment.setComment(INIT_COMMENT);

        int temp = goodCommentService.insertGoodComment(goodComment);

        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }

    /**
     * updateGoodCommentContent
     * TODO
     * @description /api/good/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "good/comment/update/content", method = RequestMethod.POST)
    public JsonResult updateGoodCommentContent(@RequestParam(value = "id") String id,
                                               @RequestParam(value = "content") String content) {


        int temp = goodCommentService.updateGoodCommentContent(content,id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * updateGoodCommentThump
     * TODO
     * @description /api/good/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "good/comment/update/thumb_up", method = RequestMethod.POST)
    public JsonResult updateGoodCommentThump(@RequestParam(value = "id") String id) {


        int temp = goodCommentService.updateGoodCommentThumb(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,null);

    }

    /**
     * updateGoodCommentComment
     * TODO
     * @description /api/good/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "good/comment/update/comment", method = RequestMethod.POST)
    public JsonResult updateGoodCommentComment(@RequestParam(value = "id") String id) {


        int temp = goodCommentService.updateGoodCommentComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }

    /**
     * deleteGoodComment
     * TODO
     * @description /api/good/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "good/comment/delete", method = RequestMethod.POST)
    public JsonResult deleteGoodComment(@RequestParam(value = "id") String id) {


        int temp = goodCommentService.deleteGoodComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }
}
