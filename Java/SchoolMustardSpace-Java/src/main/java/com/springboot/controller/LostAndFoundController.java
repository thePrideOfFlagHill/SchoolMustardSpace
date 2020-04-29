package com.springboot.controller;

import com.springboot.domain.LostAndFound;
import com.springboot.service.LostAndFoundService;
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
 * @create 2020/4/29
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/lost_and_found")
public class LostAndFoundController {
    @Autowired
    private LostAndFoundService lostAndFoundService;

    @PostMapping("/insert")
    public JsonResult insertInfo(@RequestBody Map<String , String> a){
        String uuid = UUID.randomUUID().toString();
        LostAndFound lostAndFound = new LostAndFound();
        lostAndFound.setId(uuid);
        lostAndFound.setUserId(Integer.parseInt(a.get("userId")));
        lostAndFound.setTitle(a.get("title").toString());
        lostAndFound.setContent(a.get("content").toString());
        lostAndFound.setImage(a.get("image").toString());
        lostAndFound.setLabel(a.get("label").toString());
        lostAndFound.setLocation(a.get("location").toString());
        lostAndFound.setIsDone(Integer.parseInt(a.get("isDone")));
        lostAndFound.setTime(a.get("time").toString());
        lostAndFound.setIsLost(Integer.parseInt(a.get("isLost")));
        lostAndFound.setThumbUp(Integer.parseInt(a.get("thumbUp")));
        lostAndFound.setCollect(Integer.parseInt(a.get("collect")));
        lostAndFound.setComment(Integer.parseInt(a.get("comment")));

        String msg = lostAndFoundService.insertLostAndFound(lostAndFound);
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

    @GetMapping("/update/isDone")
    public JsonResult updateIsDone(@Param("id")String id){
        String msg = lostAndFoundService.updateSome(1 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/thumbUp")
    public JsonResult updateThumbUp(@Param("id")String id){
        String msg = lostAndFoundService.updateSome(2 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/collect")
    public JsonResult updateCollect(@Param("id")String id){
        String msg = lostAndFoundService.updateSome(3 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/comment")
    public JsonResult updateComment(@Param("id")String id){
        String msg = lostAndFoundService.updateSome(4 , id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult delete(@Param("id")String id){
        String msg = lostAndFoundService.deleteById(id);

        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/query/all")
    public JsonResult queryAll(){
        List<LostAndFound> lostAndFoundList = new LinkedList<LostAndFound>();
        lostAndFoundList = lostAndFoundService.selectAll();
        return JsonResult.build(200 , "succeed" , lostAndFoundList);
    }

    @GetMapping("/query/id")
    public JsonResult queryId(@Param("id")String id){
        LostAndFound lostAndFound = lostAndFoundService.selectByReason(1 , id , 0);
        return JsonResult.build(200 , "succeed" , lostAndFound);
    }

    @GetMapping("/query/userId")
    public JsonResult queryUserId(@Param("id")int userId){
        LostAndFound lostAndFound = lostAndFoundService.selectByReason(1 , null , userId);
        return JsonResult.build(200 , "succeed" , lostAndFound);
    }


}
