package com.springboot.controller;

import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GetController
 * TODO
 * @description 所有的get请求的接口
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class GetController {

    @Autowired
    private TaskService taskService;


    //请求队列的思考。。。。。
    @GetMapping("/test")
    public JsonResult a(){
        return null;
    }

}
