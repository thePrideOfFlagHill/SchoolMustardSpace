package com.springboot.service;

import com.springboot.domain.Adminuser;
import java.util.ArrayList;

/**
 * AdminuserService
 * TODO
 * @description 数据服务层 AdminuserService
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/29
 */
public interface AdminuserService {
    String login(String accountNumber, String password);
    String register(Adminuser adminuser);
    String findPassword(String accountNumber, String newPassword);
    String changePassword(String accountNumber, String password, String newPassword);
    String updateAdminuserMessage(Adminuser adminuser);
    String deleteAdminuser(String accountNumber);
    ArrayList<Adminuser> queryAllAdminuser();
    Adminuser queryOneAdminuser(String accountNumber);
    Adminuser queryOneUserById(String id);
    int selectId(String accountNumber);
}
