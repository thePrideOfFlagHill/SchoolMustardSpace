package com.springboot.controller;

import com.springboot.constant.GoodCommentConstant;
//import com.springboot.domain.LostFoundComment;
import com.springboot.domain.Comment;
import com.springboot.service.LostFoundCommentService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TaskCommentPostController
 * TODO
 * @description 所有的post请求的接口
 * 1./api/lostfound/comment/insert 发布任务用接口 post为一个json整体对应任务实体domain
 * 2./api/lostfound/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 3./api/lostfound/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 4./api/lostfound/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 5./api/lostfound/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.2
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LostFoundCommentPostController implements GoodCommentConstant {

    @Autowired
    private LostFoundCommentService lostFoundCommentService;

    /**
     * insertLostFoundComment
     * TODO
     * @description /api/lostfound/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "lostfound/comment/insert", method = RequestMethod.POST)
    public JsonResult insertLostFoundComment(@RequestBody Comment lostFoundComment) {

        //实例化生成
        UuidResult uuidResult = new UuidResult();

        DateResult dateResult = new DateResult();

        //发布初始化
        lostFoundComment.setId(uuidResult.setUuidResult());
        lostFoundComment.setPublish_time(dateResult.getCurrentTime());
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
    @RequestMapping(value = "lostfound/comment/update/content", method = RequestMethod.POST)
    public JsonResult updateLostFoundCommentContent(@RequestParam(value = "id") String id,
                                                    @RequestParam(value = "content") String content) {


        int temp = lostFoundCommentService.updateLostFoundCommentContent(content,id);

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
    @RequestMapping(value = "lostfound/comment/update/thumb_up", method = RequestMethod.POST)
    public JsonResult updateLostFoundCommentThump(@RequestParam(value = "id") String id) {


        int temp = lostFoundCommentService.updateLostFoundCommentThumb(id);

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
    @RequestMapping(value = "lostfound/comment/update/comment", method = RequestMethod.POST)
    public JsonResult updateLostFoundCommentComment(@RequestParam(value = "id") String id) {


        int temp = lostFoundCommentService.updateLostFoundCommentComment(id);

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
    @RequestMapping(value = "lostfound/comment/delete", method = RequestMethod.POST)
    public JsonResult deleteLostFoundComment(@RequestParam(value = "id") String id) {


        int temp = lostFoundCommentService.deleteLostFoundComment(id);

        //temp为记录sql语句影响行数 成功为1
        if(temp==SQL_FAIL){

            return JsonResult.errorMsg(MSG_FAIL);

        }

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,null);

    }


}
