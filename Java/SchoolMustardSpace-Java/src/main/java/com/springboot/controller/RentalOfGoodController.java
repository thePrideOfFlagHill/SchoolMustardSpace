package com.springboot.controller;

import com.springboot.constant.RentalOfGoodConstant;
import com.springboot.domain.RentalOfGood;
import com.springboot.service.RentalOfGoodService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/30
 * @description:物品租赁类控制层
 * 1./api/rental/insert             增加物品租赁
 * 2./api/rental/upload/image       增加物品租赁里的图片
 * 3./api/rental/update             编辑物品租赁
 * 4./api/rental/rent               更新租出状态
 * 5./api/rental/update/isDone      更新完成状况
 * 6./api/rental/update/thumbUp     点赞数+1
 * 7./api/rental/update/collect     收藏数+1
 * 8./api/rental/update/comment     评论数+1
 * 9./api/rental/delete             删除某个失物招领
 * 10./api/rental/query/all          获得全部失物招领的信息
 * 11./api/rental/query/id          根据条目id查询失物招领的信息
 * 12./api/rental/query/userId      根据userId查询食物招领的信息
 * 13./api/rental/query/like/title  标题的模糊查找
 * 14./api/rental/query/like/content 内容的模糊查找
 * 15./api/rental/query/like/lebel  标签的模糊查找
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/rental")
public class RentalOfGoodController implements RentalOfGoodConstant {
    @Autowired
    private RentalOfGoodService rentalOfGoodService;

    @PostMapping("/insert")
    public JsonResult insertInfo(@RequestBody Map<String , String> resMap) {
        String uuid = UUID.randomUUID().toString();
        RentalOfGood rentalOfGood = new RentalOfGood();
        rentalOfGood.setId(uuid);
        rentalOfGood.setUserId(Integer.parseInt(resMap.get("userId")));
        rentalOfGood.setTitle(resMap.get("title").toString());
        rentalOfGood.setContent(resMap.get("content".toString()));
        rentalOfGood.setImage(resMap.get("image").toString());
        rentalOfGood.setLabel(resMap.get("label").toString());
        rentalOfGood.setLocation(resMap.get("location").toString());
        rentalOfGood.setUnitPrice(resMap.get("unitPrice").toString());
        rentalOfGood.setStartTime(resMap.get("startTime").toString());
        rentalOfGood.setEndTime(resMap.get("endTime").toString());
        rentalOfGood.setNewDegree(Integer.parseInt(resMap.get("newDegree")));

        String msg = rentalOfGoodService.insertRentalOfGood(rentalOfGood);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,uuid);
        }
        else return JsonResult.errorMsg(msg);
    }

    /**
     * 待解决
     * @return
     */
    @PostMapping("/upload/image")
    public JsonResult uploadImage(){
        return null;
    }

    /**
     * 待解决
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(){
        return null;
    }

    @GetMapping("/rent")
    public JsonResult rent(@RequestBody Map<String, String> map){
        String msg = rentalOfGoodService.insertTime(1 , map.get("id"));
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/isDone")
    public JsonResult updateIsDone(@RequestBody Map<String, String> map){
        String msg = rentalOfGoodService.updateSome(1 , map.get("id"));
        String msg2 = rentalOfGoodService.insertTime(2 , map.get("id"));

        if(msg.equals(MSG_SUCCEED) && msg2.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/thumbUp")
    public JsonResult updateThumbUp(@RequestBody Map<String, String> map){
        String msg = rentalOfGoodService.updateSome(2 , map.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/collect")
    public JsonResult updateCollect(@RequestBody Map<String, String> map){
        String msg = rentalOfGoodService.updateSome(3 , map.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/comment")
    public JsonResult updateComment(@RequestBody Map<String, String> map ){
        String msg = rentalOfGoodService.updateSome(4 , map.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult delete(@RequestBody Map<String , String> resMap){
        String msg = rentalOfGoodService.deleteById(resMap.get("id").toString());

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    /**
     * /query接口：beta版本加敏感词模块，敏感词版块使用tried树实现
     * @return
     */
    @GetMapping("/query/all")
    public JsonResult queryAll(){
        List<RentalOfGood> rentalOfGoods = new LinkedList<RentalOfGood>();
        rentalOfGoods = rentalOfGoodService.selectList(1 , 0);
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("/query/id")
    public JsonResult queryId(@RequestBody Map<String, String> map){
        RentalOfGood rentalOfGood = rentalOfGoodService.selectOne(map.get("id"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGood);
    }

    @GetMapping("/query/userId")
    public JsonResult queryUserId(@RequestBody Map<String, String> map){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectList(2 , Integer.parseInt(map.get("userId")));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    /**
     * 模糊查询beta版本运用tried树实现
     */
    @GetMapping("query/like/title")
    public JsonResult queryLikeTitle(@RequestBody Map<String, String> map){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(1 , map.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("query/like/content")
    public JsonResult queryLikeContent(@RequestBody Map<String, String> map){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(2 , map.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

    @GetMapping("query/like/label")
    public JsonResult queryLikeLabel(@RequestBody Map<String, String> map){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(3 , map.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , rentalOfGoods);
    }

}
