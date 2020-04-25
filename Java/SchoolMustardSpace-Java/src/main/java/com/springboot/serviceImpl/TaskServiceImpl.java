package com.springboot.serviceImpl;

import com.springboot.mapper.TaskMapper;
import com.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TaskServiceImpl
 * TODO
 * @description TaskServiceImpl 服务实现层
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
}
    