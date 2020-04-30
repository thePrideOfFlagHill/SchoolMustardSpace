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
 * @description:失物招领类控制层
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

        lostAndFound.setTime(a.get("time").toString());
        lostAndFound.setIsLost(Integer.parseInt(a.get("isLost")));

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


    /**
     * /query接口：beta版本加敏感词模块，敏感词版块使用tried树实现
     * @return
     */
    @GetMapping("/query/all")
    public JsonResult queryAll(){
        List<LostAndFound> lostAndFoundList = new LinkedList<LostAndFound>();
        lostAndFoundList = lostAndFoundService.selectList(1 , 0);
        return JsonResult.build(200 , "succeed" , lostAndFoundList);
    }

    @GetMapping("/query/id")
    public JsonResult queryId(@Param("id")String id){
        LostAndFound lostAndFound = lostAndFoundService.selectOne( id );
        return JsonResult.build(200 , "succeed" , lostAndFound);
    }

    @GetMapping("/query/userId")
    public JsonResult queryUserId(@Param("userId")int userId){
        List<LostAndFound> lostAndFound = lostAndFoundService.selectList(2 , userId);
        return JsonResult.build(200 , "succeed" , lostAndFound);
    }

    /**
     * 模糊查询beta版本运用tried树实现
     */
    @GetMapping("query/like/title")
    public JsonResult queryLikeTitle(@Param("text")String text){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(1 , text);
        return JsonResult.build(200 , "succeed" , lostAndFounds);
    }

    @GetMapping("query/like/content")
    public JsonResult queryLikeContent(@Param("text")String text){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(2 , text);
        return JsonResult.build(200 , "succeed" , lostAndFounds);
    }

    @GetMapping("query/like/label")
    public JsonResult queryLikeLabel(@Param("text")String text){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(3 , text);
        return JsonResult.build(200 , "succeed" , lostAndFounds);
    }
}
