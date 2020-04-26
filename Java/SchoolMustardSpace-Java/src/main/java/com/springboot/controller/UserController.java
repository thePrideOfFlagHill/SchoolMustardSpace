package com.springboot.controller;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 * TODO
 * @description
 *
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.4.26
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "accountNumber") String accountNumber, @RequestParam(value = "password")String password){
        return userService.login(accountNumber,password);
    }

}
