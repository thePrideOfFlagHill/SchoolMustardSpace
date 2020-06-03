package com.springboot.controller;

import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.threadstool.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.UUID;

/**
 * TestController
 * TODO
 * @description TestController
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.6.03
 */

@RestController
public class TestController {

    @Autowired
    ThreadPoolManager threadPoolManager;

    /**
     * 测试模拟请求 入口
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    public JsonResult start(@PathVariable Long id) {
        //模拟的随机数
        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();

        threadPoolManager.addOrders(orderNo);

        return threadPoolManager.addOrders(orderNo);
    }

    /**
     * 停止服务
     * @param id
     * @return
     */
    @GetMapping("/end/{id}")
    public String end(@PathVariable Long id) {

        threadPoolManager.shutdown();

        Queue q = threadPoolManager.getMsgQueue();
        System.out.println("关闭了线程服务，还有未处理的信息条数：" + q.size());
        return "Test ThreadPoolExecutor start";
    }
}
