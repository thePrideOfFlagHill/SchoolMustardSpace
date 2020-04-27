package com.springboot.controller;

import com.springboot.domain.User;
import com.springboot.service.UserService;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JsonResult login(@RequestParam(value = "accountNumber") String accountNumber,
                        @RequestParam(value = "password") String password){
        String msg = userService.login(accountNumber,password);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody User user){
        String msg = userService.register(user);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/api/user/find/password", method = RequestMethod.POST)
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                               @RequestParam(value = "newPassword") String newPassword){
        String msg = userService.findPassword(accountNumber, newPassword);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/api/user/update/password", method = RequestMethod.POST)
    public JsonResult changePassword(@RequestParam(value = "accountNumber") String accountNumber,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "newPassword") String newPassword){
        String msg = userService.changePassword(accountNumber, password, newPassword);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }
}
