package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.springboot.constant.TaskConstant;
import com.springboot.domain.Task;
import com.springboot.service.TaskService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class PageController implements TaskConstant {

    @Autowired
    private TaskService taskService;


    /**
     * queryTaskAll
     * TODO
     * @description /api/task/query/all 查询全部任务用接口
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.4.27
     */
    @RequestMapping(value = "task/query/all", method = RequestMethod.GET)
    public JsonResult queryTaskAll() {

        PageHelper.startPage(1,1);

        List<Task> list = this.taskService.getAllTask();

        return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED,list);

    }

}
