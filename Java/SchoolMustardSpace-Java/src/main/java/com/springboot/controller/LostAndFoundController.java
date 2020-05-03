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
 * 1./api/lost_and_found/insert             增加失物招领
 * 2./api/lost_and_found/upload/image       增加失物招领里的图片
 * 3./api/lost_and_found/update             编辑失物招领
 * 4./api/lost_and_found/update/isDone      更新完成状况
 * 5./api/lost_and_found/update/thumbUp     点赞数+1
 * 6./api/lost_and_found/update/collect     收藏数+1
 * 7./api/lost_and_found/update/comment     评论数+1
 * 8./api/lost_and_found/delete             删除某个失物招领
 * 9./api/lost_and_found/query/all          获得全部失物招领的信息
 * 10./api/lost_and_found/query/id          根据条目id查询失物招领的信息
 * 11./api/lost_and_found/query/userId      根据userId查询食物招领的信息
 * 12./api/lost_and_found/query/like/title  标题的模糊查找
 * 13./api/lost_and_found/query/like/content 内容的模糊查找
 * 14./api/lost_and_found/query/like/lebel  标签的模糊查找
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
