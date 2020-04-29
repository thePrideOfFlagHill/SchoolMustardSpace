package com.springboot.service.Impl;

import com.springboot.domain.Adminuser;
import com.springboot.service.AdminuserService;

import java.util.ArrayList;

/**
 * AdminserServiceImpl
 * TODO
 * @description AdminserServiceImpl 服务实现层
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/29
 */
public class AdminuserServiceImpl implements AdminuserService {
    @Override
    public String login(String accountNumber, String password) {
        return null;
    }

    @Override
    public String register(Adminuser adminuser) {
        return null;
    }

    @Override
    public String findPassword(String accountNumber, String newPassword) {
        return null;
    }

    @Override
    public String changePassword(String accountNumber, String password, String newPassword) {
        return null;
    }

    @Override
    public String updateUserMessage(Adminuser adminuser) {
        return null;
    }

    @Override
    public String deleteAdminuser(String accountNumber) {
        return null;
    }

    @Override
    public ArrayList<Adminuser> queryAllAdminuser() {
        return null;
    }

    @Override
    public Adminuser queryOneAdminuser(String accountNumber) {
        return null;
    }
}
