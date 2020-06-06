package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.springboot.constant.PageConstant;
import com.springboot.constant.TaskConstant;
import com.springboot.domain.Comment;
import com.springboot.domain.LostAndFound;
import com.springboot.domain.RentalOfGood;
import com.springboot.domain.Task;
import com.springboot.service.*;
import com.springboot.utils.jsontool.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PageController implements PageConstant {

    @Autowired
    private AdminuserService adminuserService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private LostAndFoundService lostAndFoundService;

    @Autowired
    private RentalOfGoodService rentalOfGoodService;

    @Autowired
    private TaskCommentService taskCommentService;

    @Autowired
    private LostFoundCommentService lostFoundCommentService;

    @Autowired
    private GoodCommentService goodCommentService;


    //=================================== 管理员模块查询 =======================================
    @GetMapping("/admin/query/all/{pageNum}")
    public JsonResult queryAllAdminuser(@PathVariable(value = "pageNum") int pageNum){
        PageHelper.startPage(pageNum,PAGE_SIZE);

        Object data = adminuserService.queryAllAdminuser();

        if(data != null){
            return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }
    //=================================== 管理员模块查询 ========================================


    //==================================== 用户模块查询 =========================================
    @GetMapping("/user/query/all/{pageNum}")
    public JsonResult queryAllUser(@PathVariable(value = "pageNum") int pageNum){
        PageHelper.startPage(pageNum,PAGE_SIZE);

        Object data = userService.queryAllUser();

        if(data != null){
            return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }
    //==================================== 用户模块查询 =========================================


    //================================== 发布任务模块查询 ========================================
    @GetMapping("/task/query/all/{pageNum}")
    public JsonResult queryTaskAll(@PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Task> list = this.taskService.getAllTask();

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    @GetMapping("/task/query/user_id/{user_id}/{pageNum}")
    public JsonResult queryTaskByUserId(@PathVariable String user_id,
                                        @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Task> list = this.taskService.queryTaskByUserId(user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("/task/query/like/title/{pageNum}")
    public JsonResult queryTaskLikeContent(@Param("title")String title,
                                           @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Task> list = this.taskService.getLike(2, title);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("/task/query/like/content/{pageNum}")
    public JsonResult queryTaskLikeTitle(@Param("content")String content,
                                         @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Task> list = this.taskService.getLike(1, content);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("/task/query/like/label/{pageNum}")
    public JsonResult queryTaskLikeLabel(@Param("label") String label,
                                         @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Task> list = this.taskService.getLike(3, label);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }
    //================================== 发布任务模块查询 ========================================


    //================================== 失物招领模块查询 ========================================
    @GetMapping("/lost_and_found/query/all/{pageNum}")
    public JsonResult queryLostAndFoundAll(@PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<LostAndFound> lostAndFoundList = new LinkedList<LostAndFound>();

        lostAndFoundList = lostAndFoundService.selectList(1 , 0);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFoundList);
    }

    @GetMapping("/lost_and_found/query/userId/{pageNum}")
    public JsonResult queryLostAndFoundByUserId(@Param("userId")int userId,
                                  @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<LostAndFound> lostAndFound = lostAndFoundService.selectList(2 , userId);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFound);
    }

    @GetMapping("/lost_and_found/query/like/title/{pageNum}")
    public JsonResult queryLostAndFoundLikeTitle(@Param("text")String text,
                                     @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(1 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }

    @GetMapping("/lost_and_found/query/like/content/{pageNum}")
    public JsonResult queryLostAndFoundLikeContent(@Param("text")String text,
                                       @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(2 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }

    @GetMapping("/lost_and_found/query/like/label/{pageNum}")
    public JsonResult queryLostAndFoundLikeLabel(@Param("text")String text,
                                     @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(3 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }

    //================================== 失物招领模块查询 ========================================


    //================================== 物品租赁模块查询 ========================================
    @GetMapping("/rental/query/all/{pageNum}")
    public JsonResult queryRentalAll(@PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<RentalOfGood> rentalOfGoods = new LinkedList<RentalOfGood>();

        rentalOfGoods = rentalOfGoodService.selectList(1 , 0);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("/rental/query/userId/{pageNum}")
    public JsonResult queryRentalByUserId(@Param("userId")int userId,
                                  @PathVariable(value = "pageNum") int pageNum){
        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectList(2 , userId);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("/rental/query/like/title/{pageNum}")
    public JsonResult queryRentalLikeTitle(@Param("text")String text,
                                     @PathVariable(value = "pageNum") int pageNum){
        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(1 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("/rental/query/like/content/{pageNum}")
    public JsonResult queryRentalLikeContent(@Param("text")String text,
                                       @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(2 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("/rental/query/like/label/{pageNum}")
    public JsonResult queryRentalLikeLabel(@Param("text")String text,
                                     @PathVariable(value = "pageNum") int pageNum){

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(3 , text);

        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }
    //================================== 物品租赁模块查询 ========================================


    //================================= 发布任务评论模块查询 ======================================
    @GetMapping("task/comment/query/all/{pageNum}")
    public JsonResult queryTaskCommentAll(@PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.taskCommentService.select(1, null);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("query/task/comment/user_id/{user_id}/{pageNum}")
    public JsonResult queryTaskCommentByUserId(@PathVariable String user_id,
                                               @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.taskCommentService.select(2, user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("query/task/comment/table_id/{table_id}/{pageNum}")
    public JsonResult queryTaskCommentByTableId(@PathVariable String table_id,
                                                @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.taskCommentService.select(3, table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    //================================= 发布任务评论模块查询 ======================================


    //================================= 失物招领评论模块查询 ======================================
    @GetMapping("lostfound/comment/query/all/{pageNum}")
    public JsonResult queryLostFoundCommentAll(@PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.lostFoundCommentService.select(1,null);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("query/lostfound/comment/user_id/{user_id}/{pageNum}")
    public JsonResult queryLostFoundCommentByUserId(@PathVariable String user_id,
                                                    @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.lostFoundCommentService.select(2, user_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }

    @GetMapping("query/lostfound/comment/table_id/{table_id}/{pageNum}")
    public JsonResult queryLostFoundCommentByTableId(@PathVariable String table_id,
                                                     @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.lostFoundCommentService.select(3, table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }
    //================================= 失物招领评论模块查询 ======================================


    //================================= 物品租赁评论模块查询 ======================================
    @GetMapping("good/comment/query/all/{pageNum}")
    public JsonResult queryGoodCommentAll(@PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.goodCommentService.select(1,null);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

    @GetMapping("query/good/comment/user_id/{user_id}/{pageNum}")
    public JsonResult queryGoodCommentByUserId(@PathVariable String user_id,
                                               @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.goodCommentService.select(2, user_id);

        return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED,list);
    }

    @GetMapping("query/good/comment/table_id/{table_id}/{pageNum}")
    public JsonResult queryGoodCommentByTableId(@PathVariable String table_id,
                                                @PathVariable(value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum,PAGE_SIZE);

        List<Comment> list = this.goodCommentService.select(3, table_id);

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);
    }
    //================================= 物品租赁评论模块查询 ======================================
}
