package com.springboot.utils.threadstool;

import com.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * BusinessThread
 * TODO
 * @description BusinessThread
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.6.03
 */

@Component
@Scope("prototype")//spring 多例
public class BusinessThread implements Runnable{

    private String acceptStr;

    public BusinessThread(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    public String getAcceptStr() {
        return acceptStr;
    }

    public void setAcceptStr(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    @Override
    public void run() {
        //业务操作
        System.out.println("多线程已经处理用户token插入系统，token号："+acceptStr);

        //线程阻塞
        /*try {
            Thread.sleep(1000);
            System.out.println("多线程已经处理订单插入系统，订单号："+acceptStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}