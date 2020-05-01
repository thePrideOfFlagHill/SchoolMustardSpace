package com.springboot.controller;

import com.springboot.domain.User;
import com.springboot.service.UserService;
import com.springboot.utils.encryptiontool.DesEncryption;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * UserController
 * TODO
 * @description 所有有关用户操作的接口
 *
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.4.26
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestParam(value = "accountNumber") String accountNumber,
                        @RequestParam(value = "password") String password){
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.login(accountNumber, str);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        user.setPassword(str);
        String msg = userService.register(user);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/find/password", method = RequestMethod.POST)
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                               @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr = DesEncryption.encryptMode(newPassword.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.findPassword(accountNumber, str);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/update/password", method = RequestMethod.POST)
    public JsonResult changePassword(@RequestParam(value = "accountNumber") String accountNumber,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr1 = DesEncryption.encryptMode(password.getBytes());
        byte[] secretArr2 = DesEncryption.encryptMode(newPassword.getBytes());
        String str1 = DesEncryption.byte2Hex(secretArr1);
        String str2 = DesEncryption.byte2Hex(secretArr2);
        String msg = userService.changePassword(accountNumber, str1, str2);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult updateUserMessage(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        user.setPassword(str);
        String msg = userService.updateUserMessage(user);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonResult deleteUser(@RequestParam(value = "accountNumber") String accountNumber){

        String msg = userService.deleteUser(accountNumber);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public JsonResult queryAllUser(){
        Object data = userService.queryAllUser();
        if(data != null){
            return JsonResult.build(200,"succeed", data);
        }
        else return JsonResult.errorMsg("fail");
    }

    @RequestMapping(value = "/query/accountNumber/{accountNumber}", method = RequestMethod.GET)
    public JsonResult queryOneUser(@PathVariable(value = "accountNumber") String accountNumber){
        Object data = userService.queryOneUser(accountNumber);
        if(data != null){
            return JsonResult.build(200,"succeed", data);
        }
        else return JsonResult.errorMsg("fail");
    }
}
