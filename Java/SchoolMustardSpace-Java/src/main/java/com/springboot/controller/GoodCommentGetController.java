package com.springboot.controller;

import com.springboot.domain.GoodComment;
import com.springboot.domain.TaskComment;
import com.springboot.service.GoodCommentService;
import com.springboot.service.TaskCommentService;
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
public class GoodCommentGetController {

    @Autowired
    private GoodCommentService goodCommentService;

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

        List<GoodComment> list = this.goodCommentService.getAllGoodComment();

        return JsonResult.ok(list);

    }

    /**
     * queryGoodCommentById
     * TODO
     * @description /api/good/comment/query/id/{id} 根据条目id查询任务评论（单个对应）
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.5.1
     */
    @RequestMapping(value = "query/good/comment/id/{id}", method = RequestMethod.GET)
    public JsonResult queryGoodCommentById(@PathVariable String id) {

        GoodComment goodComment = this.goodCommentService.queryGoodCommentById(id);

        return JsonResult.ok(goodComment);

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

        List<GoodComment> list = this.goodCommentService.queryGoodCommentByUserId(user_id);

        return JsonResult.ok(list);

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

        List<GoodComment> list = this.goodCommentService.queryGoodCommentByTableId(table_id);

        return JsonResult.ok(list);

    }
}
    