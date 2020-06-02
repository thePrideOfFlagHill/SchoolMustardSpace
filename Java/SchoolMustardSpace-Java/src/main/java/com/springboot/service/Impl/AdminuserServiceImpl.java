package com.springboot.service.Impl;

import com.springboot.constant.AdminuserConstant;
import com.springboot.domain.Adminuser;
import com.springboot.mapper.AdminuserMapper;
import com.springboot.service.AdminuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * AdminuserServiceImpl
 * TODO
 * @description AdminuserServiceImpl 服务实现层
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/29
 */
@Service
public class AdminuserServiceImpl implements AdminuserService, AdminuserConstant {
    @Resource
    private AdminuserMapper adminuserMapper;

    @Override
    public String login(String accountNumber, String password) {
        int count = adminuserMapper.selectAdminuserByAccountNumberAndPassword(accountNumber, password);
        return count == 1 ? MSG_SUCCEED : MSG_FAIL;
    }

    @Override
    public String register(Adminuser adminuser) {
        int result = adminuserMapper.insertAdminuser(adminuser);
        return result == 1 ? MSG_SUCCEED : MSG_FAIL;
    }

    @Override
    public String findPassword(String accountNumber, String newPassword) {
        int result = adminuserMapper.updateAdminuserPassword(accountNumber, newPassword);
        return result == 1 ? MSG_SUCCEED : MSG_FAIL;
    }

    @Override
    public String changePassword(String accountNumber, String password, String newPassword) {
        int count = adminuserMapper.selectAdminuserByAccountNumberAndPassword(accountNumber, password);
        if(count == 1){
            int result = adminuserMapper.updateAdminuserPassword(accountNumber, newPassword);
            if(result == 1){
                return MSG_SUCCEED;
            }
        }
        return MSG_FAIL;
    }

    @Override
    public String updateAdminuserMessage(Adminuser adminuser) {
        int result = adminuserMapper.updateAdminuser(adminuser);
        return result == 1 ? MSG_SUCCEED : MSG_FAIL;
    }

    @Override
    public String deleteAdminuser(String accountNumber) {
        int result = adminuserMapper.deleteAdminuserByAccountNumber(accountNumber);
        return result == 1 ? MSG_SUCCEED : MSG_FAIL;
    }

    @Override
    public ArrayList<Adminuser> queryAllAdminuser() {
        return adminuserMapper.selectAllAdminuser();
    }

    @Override
    public Adminuser queryOneAdminuser(String accountNumber) {
        return adminuserMapper.selectAdminuserByAccountNumber(accountNumber);
    }

    @Override
    public Adminuser queryOneUserById(String id) {return adminuserMapper.selectUserById(id);}

    public int selectId(String accountNumber) {
        return adminuserMapper.selectId(accountNumber);
    }
}
