package com.springboot.service.Impl;

import com.springboot.domain.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String accountNumber, String password) {
        int count = userMapper.selectUserByIdAndPassword(accountNumber,password);//查询user表中账号密码相同的记录数
        if(count == 1){
            return "succeed";
        }
        return "fail";
    }
}
