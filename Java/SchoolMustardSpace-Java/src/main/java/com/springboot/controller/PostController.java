package com.springboot.controller;

import com.springboot.domain.LostAndFound;
import com.springboot.mapper.LostAndFoundMapper;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;


/**
 * PostController
 * TODO
 * @description 所有的post请求的接口
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private LostAndFoundMapper lostAndFoundMapper;

    @PostMapping("/test")
    public JsonResult a(@RequestBody Map<String , String> a){
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
        lostAndFoundMapper.insertLostAndFound(lostAndFound);
        return JsonResult.build(200 , "succeed" , uuid);
    }

}
