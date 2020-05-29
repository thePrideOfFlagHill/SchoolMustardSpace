package com.springboot.controller;

import com.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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


}
