package com.springboot.service.Impl;

import com.springboot.domain.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * UserServiceImpl
 * TODO
 * @description UserServiceImpl 服务实现层
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String accountNumber, String password) {

        int count = userMapper.selectUserByAccountNumberAndPassword(accountNumber, password);//查询user表中账号密码相同的记录数

        return count == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    @Override
    public String register(User user){

        int result = userMapper.insertUser(user);

        return result == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    @Override
    public String findPassword(String accountNumber, String newPassword) {

        int result = userMapper.updateUserPassword(accountNumber, newPassword);

        return result == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    @Override
    public String changePassword(String accountNumber, String password, String newPassword) {

        int count = userMapper.selectUserByAccountNumberAndPassword(accountNumber, password);

        if(count == 1){
            int result = userMapper.updateUserPassword(accountNumber, newPassword);
            if(result == 1){
                return Constant.MSG_SUCCEED;
            }
        }

        return Constant.MSG_FAIL;
    }

    @Override
    public String updateUserMessage(User user) {

        int result = userMapper.updateUser(user);

        return result == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    @Override
    public String deleteUser(String accountNumber) {

        int result = userMapper.deleteUserByAccountNumber(accountNumber);

        return result == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    @Override
    public ArrayList<User> queryAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User queryOneUser(String accountNumber) {
        return userMapper.selectUserByAccountNumber(accountNumber);
    }

    public User queryOneUserById(String id) {
        return userMapper.selectUserById(id);
    }

    public int selectId(String accountNumber){
        return userMapper.selectId(accountNumber);
    }
}
