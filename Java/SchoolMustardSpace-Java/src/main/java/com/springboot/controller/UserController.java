package com.springboot.controller;

import com.springboot.constant.UserConstant;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import com.springboot.utils.encryptiontool.DesEncryption;
import com.springboot.utils.jsontool.JsonResult;
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
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController implements UserConstant {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public JsonResult login(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.login(user.getAccountNumber(), str);
        int id = userService.selectId(user.getAccountNumber());
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,id);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/register")
    public JsonResult register(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        user.setPassword(str);
        String msg = userService.register(user);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/find/password")
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                                   @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr = DesEncryption.encryptMode(newPassword.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.findPassword(accountNumber, str);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update/password")
    public JsonResult changePassword(@RequestParam(value = "accountNumber") String accountNumber,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr1 = DesEncryption.encryptMode(password.getBytes());
        byte[] secretArr2 = DesEncryption.encryptMode(newPassword.getBytes());
        String str1 = DesEncryption.byte2Hex(secretArr1);
        String str2 = DesEncryption.byte2Hex(secretArr2);
        String msg = userService.changePassword(accountNumber, str1, str2);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update")
    public JsonResult updateUserMessage(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        user.setPassword(str);
        String msg = userService.updateUserMessage(user);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult deleteUser(@RequestParam(value = "accountNumber") String accountNumber){
        String msg = userService.deleteUser(accountNumber);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/query/all")
    public JsonResult queryAllUser(){
        Object data = userService.queryAllUser();
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }

    @GetMapping("/query/accountNumber/{accountNumber}")
    public JsonResult queryOneUser(@PathVariable(value = "accountNumber") String accountNumber){
        Object data = userService.queryOneUser(accountNumber);
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }

    @GetMapping("/query/id/{id}")
    public JsonResult queryOneUserById(@PathVariable(value = "id") String accountNumber){
        Object data = userService.queryOneUserById(accountNumber);
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED,MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }

}
