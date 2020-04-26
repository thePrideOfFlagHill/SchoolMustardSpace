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
    public String login(@RequestParam(value = "accountNumber") String accountNumber,
                        @RequestParam(value = "password") String password){
        return userService.login(accountNumber, password);
    }

    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "accountNumber") String accountNumber,
                           @RequestParam(value = "password") String password){
        return userService.register(accountNumber, password);
    }

    @RequestMapping(value = "/api/user/find/password", method = RequestMethod.POST)
    public String findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                               @RequestParam(value = "newPassword") String newPassword){
        return userService.findPassword(accountNumber, newPassword);
    }

    @RequestMapping(value = "/api/user/update/password", method = RequestMethod.POST)
    public String changePassword(@RequestParam(value = "accountNumber") String accountNumber,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "newPassword") String newPassword){
        return userService.changePassword(accountNumber, password, newPassword);
    }
}
