package com.springboot.controller;

import com.springboot.constant.LostFoundCommentConstant;
import com.springboot.domain.Comment;
import com.springboot.domain.CommentPlus;
import com.springboot.domain.User;
import com.springboot.service.LostFoundCommentService;
import com.springboot.service.UserService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * LostFoundCommentController
 * TODO
 * @description 所有的LostFoundCommentController请求的接口
 * 1./api/lostfound/comment/query/all 查询全部任评论用接口
 * 2./api/lostfound/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
 * 3./api/lostfound/comment/query/user_id/{user_id} 根据用户id查询任务（多个对应）
 * 4./api/lostfound/comment/query/table_id/{table_id} 根据表条目id查询任务（多个对应）
 * 5./api/lostfound/comment/insert 发布任务用接口 post为一个json整体对应任务实体domain
 * 6./api/lostfound/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 7./api/lostfound/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 8./api/lostfound/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 9./api/lostfound/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LostFoundCommentController implements LostFoundCommentConstant {

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
    @GetMapping("lostfound/comment/query/all")
    public JsonResult queryLostFoundCommentAll() {

        List<Comment> list = this.lostFoundCommentService.select(1,null);

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
    @GetMapping("query/lostfound/comment/id/{id}")
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
    @GetMapping("query/lostfound/comment/user_id/{user_id}")
    public JsonResult queryLostFoundCommentByUserId(@PathVariable String user_id) {

        List<Comment> list = this.lostFoundCommentService.select(2, user_id);

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
    @GetMapping("query/lostfound/comment/table_id/{table_id}")
    public JsonResult queryLostFoundCommentByTableId(@PathVariable String table_id) {

        List<Comment> list = this.lostFoundCommentService.select(3, table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    /**
     * insertLostFoundComment
     * TODO
     * @description /api/lostfound/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("lostfound/comment/insert")
    public JsonResult insertLostFoundComment(@RequestBody Comment lostFoundComment) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        DateResult dateResult = new DateResult();

        //发布初始化
        lostFoundComment.setId(uuidResult.setUuidResult());
        lostFoundComment.setPublish_time(dateResult.getCurrentTime());

        String context = lostFoundComment.getContent();
        lostFoundComment.setContent(WordController.wordSeeker.replaceWords(context));


        lostFoundComment.setThumb_up(INIT_THUMB);
        lostFoundComment.setComment(INIT_COMMENT);

        int temp = lostFoundCommentService.insertLostFoundComment(lostFoundComment);

        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }

    /**
     * updateLostFoundCommentContent
     * TODO
     * @description /api/lostfound/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("lostfound/comment/update/content")
    public JsonResult updateLostFoundCommentContent(@RequestParam(value = "id") String id,
                                                    @RequestParam(value = "content") String content) {

        int temp = lostFoundCommentService.update(1, content, id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }

    /**
     * updateLostFoundCommentThump
     * TODO
     * @description /api/lostfound/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("lostfound/comment/update/thumb_up")
    public JsonResult updateLostFoundCommentThump(@RequestParam(value = "id") String id) {

        int temp = lostFoundCommentService.update(2, null, id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,null);
    }

    /**
     * updateLostFoundCommentComment
     * TODO
     * @description /api/lostfound/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("lostfound/comment/update/comment")
    public JsonResult updateLostFoundCommentComment(@RequestParam(value = "id") String id) {

        int temp = lostFoundCommentService.update(3, null, id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }

    /**
     * deleteLostFoundComment
     * TODO
     * @description /api/lostfound/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @PostMapping("lostfound/comment/delete")
    public JsonResult deleteLostFoundComment(@RequestParam(value = "id") String id) {

        int temp = lostFoundCommentService.deleteLostFoundComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){
            return JsonResult.errorMsg(MSG_FAIL);
        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);
    }
}
