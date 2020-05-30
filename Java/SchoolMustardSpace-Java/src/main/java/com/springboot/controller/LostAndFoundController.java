package com.springboot.controller;

import com.springboot.constant.LostAndFoundConstant;
import com.springboot.domain.LostAndFound;
import com.springboot.service.LostAndFoundService;
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
public class LostAndFoundController implements LostAndFoundConstant {
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

        lostAndFound.setTime(new DateResult().getCurrentTime());
        lostAndFound.setIsLost(Integer.parseInt(a.get("isLost")));

        String msg = lostAndFoundService.insertLostAndFound(lostAndFound);
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

    @GetMapping("/update/isDone")
    public JsonResult updateIsDone(@RequestBody Map<String , String> a){
        String msg = lostAndFoundService.updateSome(1 , a.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/thumbUp")
    public JsonResult updateThumbUp(@RequestBody Map<String , String> a){
        String msg = lostAndFoundService.updateSome(2 , a.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/collect")
    public JsonResult updateCollect(@RequestBody Map<String , String> a){
        String msg = lostAndFoundService.updateSome(3 , a.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/update/comment")
    public JsonResult updateComment(@RequestBody Map<String , String> a){
        String msg = lostAndFoundService.updateSome(4 , a.get("id"));

        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult delete(@RequestBody Map<String , String> resMap){
        String msg = lostAndFoundService.deleteById(resMap.get("id").toString());

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
        List<LostAndFound> lostAndFoundList = new LinkedList<LostAndFound>();
        lostAndFoundList = lostAndFoundService.selectList(1 , 0);
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFoundList);
    }

    @GetMapping("/query/id")
    public JsonResult queryId(@RequestBody Map<String , String> a){
        LostAndFound lostAndFound = lostAndFoundService.selectOne(a.get("id"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFound);
    }

    @GetMapping("/query/userId")
    public JsonResult queryUserId(@RequestBody Map<String , String> a){
        List<LostAndFound> lostAndFound = lostAndFoundService.selectList(2 , Integer.parseInt(a.get("userId")));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFound);
    }

    /**
     * 模糊查询beta版本运用tried树实现
     */
    @GetMapping("query/like/title")
    public JsonResult queryLikeTitle(@RequestBody Map<String , String> a){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(1 , a.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }

    @GetMapping("query/like/content")
    public JsonResult queryLikeContent(@RequestBody Map<String , String> a){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(2 , a.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }

    @GetMapping("query/like/label")
    public JsonResult queryLikeLabel(@RequestBody Map<String , String> a){
        List<LostAndFound> lostAndFounds = lostAndFoundService.selectLike(3 , a.get("text"));
        return JsonResult.build(STATUS_SUCCEED , MSG_SUCCEED , lostAndFounds);
    }
}
