package com.springboot.service.impl;

import com.springboot.mapper.TaskMapper;
import com.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * TODO:
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
}