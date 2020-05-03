package com.springboot.controller;

import com.springboot.constant.GoodCommentConstant;
import com.springboot.domain.GoodComment;
import com.springboot.service.GoodCommentService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.uuidtool.UuidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TaskCommentPostController
 * TODO
 * @description 所有的post请求的接口
 * 1./api/good/comment/insert 发布任务用接口 post为一个json整体对应任务实体domain
 * 2./api/good/comment/update/content 更新任务评论的内容用接口 更新修改任务评论的内容 键值对为二 key = id && content
 * 3./api/good/comment/update/thumb_up 更新任务评论的点赞+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 4./api/good/comment/update/comment 更新任务评论的评论+1用接口 更新修改任务的解决状态 键值对为一 key = id
 * 5./api/good/comment/delete 删除任务用接口 删除任务用接口 键值对为一 key = id
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.2
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GoodCommentPostController implements GoodCommentConstant {

    @Autowired
    private GoodCommentService goodCommentService;

    /**
     * insertGoodComment
     * TODO
     * @description /api/good/comment/insert 发布任务评论用接口 post为一个json整体对应任务实体domain
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.2
     */
    @RequestMapping(value = "good/comment/insert", method = RequestMethod.POST)
    public JsonResult insertGoodComment(@RequestBody GoodComment goodComment) {

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
    