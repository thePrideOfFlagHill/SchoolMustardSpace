package com.springboot.service;

import org.springframework.stereotype.Component;

/**
 * TaskService
 * TODO
 * @description 数据服务层 UserService
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
public interface UserService {
    String login(String accountNumber,String password);
    String register(String accountNumber,String password);
}
