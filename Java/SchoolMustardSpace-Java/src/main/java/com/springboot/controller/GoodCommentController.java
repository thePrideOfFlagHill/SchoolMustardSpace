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
import java.util.Map;

/**
 * GoodCommentController
 * TODO
 * @description 所有的GoodCommentController请求的接口
 * 1./api/good/comment/query/all                  查询全部任评论用接口
 * 2./api/good/comment/query/id/{id}              根据条目id查询任务评论（单个对应）
 * 3./api/good/comment/query/user_id/{user_id}    根据用户id查询任务（多个对应）
 * 4./api/good/comment/query/table_id/{table_id}  根据表条目id查询任务（多个对应）
 * 5./api/good/comment/insert                     发布任务用接口 post为一个json整体对应任务实体domain
 * 6./api/good/comment/update/content             更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 7./api/good/comment/update/thumb_up            更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 8./api/good/comment/update/comment             更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 9./api/good/comment/delete                     删除任务用接口 删除任务用接口 键值对为一 key = id
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GoodCommentController implements GoodCommentConstant {
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
    @GetMapping("good/comment/query/all")
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
    @GetMapping("query/good/comment/id/{id}")
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
    @GetMapping("query/good/comment/user_id/{user_id}")
    public JsonResult queryGoodCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.goodCommentService.queryGoodCommentByUserId(user_id);

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,list);
    }

    /**
     * queryGoodCommentByTableId
     * TODO
     * @description /api/good/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @GetMapping("query/good/comment/table_id/{table_id}")
    public JsonResult queryGoodCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.goodCommentService.queryGoodCommentByTableId(table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * insertGoodComment
     * TODO
     * @description /api/good/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("good/comment/insert")
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
    @PostMapping("good/comment/update/content")
    public JsonResult updateGoodCommentContent(@RequestBody Map<String, String> map) {

        int temp = goodCommentService.updateGoodCommentContent(map.get("content"),map.get("id"));

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
    @PostMapping("good/comment/update/thumb_up")
    public JsonResult updateGoodCommentThump(@RequestBody Map<String, String> map) {

        int temp = goodCommentService.updateGoodCommentThumb(map.get("id"));

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
    @PostMapping("good/comment/update/comment")
    public JsonResult updateGoodCommentComment(@RequestBody Map<String, String> map) {

        int temp = goodCommentService.updateGoodCommentComment(map.get("id"));

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
    @PostMapping("good/comment/delete")
    public JsonResult deleteGoodComment(@RequestBody Map<String, String> map) {

        int temp = goodCommentService.deleteGoodComment(map.get("id"));

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,null);
    }
}
