package com.springboot.controller;

import com.springboot.domain.LostAndFound;
import com.springboot.domain.RentalOfGood;
import com.springboot.service.RentalOfGoodService;
import com.springboot.utils.datetool.DateResult;
import com.springboot.utils.jsontool.JsonResult;
import org.apache.ibatis.annotations.Param;
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
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/rental")
public class RentalOfGoodController {
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
//        rentalOfGood.setStartTime(resMap.get("startTime").toString());
//        rentalOfGood.setEndTime(resMap.get("endTime").toString());
        rentalOfGood.setNewDegree(Integer.parseInt(resMap.get("newDegree")));

        String msg = rentalOfGoodService.insertRentalOfGood(rentalOfGood);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,uuid);
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
    public JsonResult rent(@Param("id") String id){
        String msg = rentalOfGoodService.insertTime(1 , id);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/isDone")
    public JsonResult updateIsDone(@Param("id")String id){
        String msg = rentalOfGoodService.updateSome(1 , id);
        String msg2 = rentalOfGoodService.insertTime(2 , id);

        if(msg.equals("succeed") && msg2.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/thumbUp")
    public JsonResult updateThumbUp(@Param("id")String id){
        String msg = rentalOfGoodService.updateSome(2 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/collect")
    public JsonResult updateCollect(@Param("id")String id){
        String msg = rentalOfGoodService.updateSome(3 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/comment")
    public JsonResult updateComment(@Param("id")String id){
        String msg = rentalOfGoodService.updateSome(4 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult delete(@Param("id")String id){
        String msg = rentalOfGoodService.deleteById(id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
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
        return JsonResult.build(200 , "succeed" , rentalOfGoods);
    }

    @GetMapping("/query/id")
    public JsonResult queryId(@Param("id")String id){
        RentalOfGood rentalOfGood = rentalOfGoodService.selectOne( id );
        return JsonResult.build(200 , "succeed" , rentalOfGood);
    }

    @GetMapping("/query/userId")
    public JsonResult queryUserId(@Param("userId")int userId){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectList(2 , userId);
        return JsonResult.build(200 , "succeed" , rentalOfGoods);
    }

    /**
     * 模糊查询beta版本运用tried树实现
     */
    @GetMapping("query/like/title")
    public JsonResult queryLikeTitle(@Param("text")String text){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(1 , text);
        return JsonResult.build(200 , "succeed" , rentalOfGoods);
    }

    @GetMapping("query/like/content")
    public JsonResult queryLikeContent(@Param("text")String text){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(2 , text);
        return JsonResult.build(200 , "succeed" , rentalOfGoods);
    }

    @GetMapping("query/like/label")
    public JsonResult queryLikeLabel(@Param("text")String text){
        List<RentalOfGood> rentalOfGoods = rentalOfGoodService.selectLike(3 , text);
        return JsonResult.build(200 , "succeed" , rentalOfGoods);
    }

}
