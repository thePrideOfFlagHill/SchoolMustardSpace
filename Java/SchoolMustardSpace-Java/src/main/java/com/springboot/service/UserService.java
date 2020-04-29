package com.springboot.service;

import com.springboot.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * UserService
 * TODO
 * @description 数据服务层 UserService
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
public interface UserService {
    String login(String accountNumber, String password);
    String register(User user);
    String findPassword(String accountNumber, String newPassword);
    String changePassword(String accountNumber, String password, String newPassword);
    String updateUserMessage(User user);
    String deleteUser(String accountNumber);
    ArrayList<User> queryAllUser();
    User queryOneUser(String accountNumber);
}
