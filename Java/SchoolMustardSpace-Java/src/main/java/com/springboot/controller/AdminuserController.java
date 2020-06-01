package com.springboot.controller;

import com.springboot.constant.AdminuserConstant;
import com.springboot.domain.Adminuser;
import com.springboot.service.AdminuserService;
import com.springboot.utils.encryptiontool.DesEncryption;
import com.springboot.utils.jsontool.JsonResult;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.Resource;
import java.util.Map;

/**
 * AdminuserController
 * TODO:
 * @description 所有有关管理员操作的接口
 * 1./api/login                                 登录接口
 * 2./api/register                              注册接口
 * 3./api/find/password                         找回密码接口
 * 4./api/update/password                       修改密码接口
 * 5./api/update                                更新用户信息接口
 * 6./api/delete                                删除用户接口
 * 7./api/query/all                             查询全部用户接口
 * 8./api/query/accountNumber/{accountNumber}   根据account_number查询用户接口
 * 9./api/quer/id/{id}                          根据id查询用户接口
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.4.29
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/admin")
public class AdminuserController implements AdminuserConstant {
    @Resource
    private AdminuserService adminuserService;

    @PostMapping("/login")
    public JsonResult login(@RequestParam(value = "accountNumber") String accountNumber,
                            @RequestParam(value = "password") String password){
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = adminuserService.login(accountNumber, str);
        int id = adminuserService.selectId(accountNumber);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, id);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/register")
    public JsonResult register(@RequestBody Adminuser adminuser){
        byte[] secretArr = DesEncryption.encryptMode(adminuser.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        adminuser.setPassword(str);
        String msg = adminuserService.register(adminuser);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/find/password")
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                                   @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr = DesEncryption.encryptMode(newPassword.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = adminuserService.findPassword(accountNumber, str);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, null);
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
        String msg = adminuserService.changePassword(accountNumber, str1, str2);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update")
    public JsonResult updateAdminuserMessage(@RequestBody Adminuser adminuser){
        byte[] secretArr = DesEncryption.encryptMode(adminuser.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        adminuser.setPassword(str);
        String msg = adminuserService.updateAdminuserMessage(adminuser);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult deleteAdminuser(@RequestParam(value = "accountNumber") String accountNumber){
        String msg = adminuserService.deleteAdminuser(accountNumber);
        if(msg.equals(MSG_SUCCEED)){
            return JsonResult.build(STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/query/all")
    public JsonResult queryAllAdminuser(){
        Object data = adminuserService.queryAllAdminuser();
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }

    @GetMapping("/query/accountNumber/{accountNumber}")
    public JsonResult queryOneAdminuser(@PathVariable(value = "accountNumber") String accountNumber){
        Object data = adminuserService.queryOneAdminuser(accountNumber);
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }

    @GetMapping("/query/id/{id}")
    public JsonResult queryOneUserById(@PathVariable(value = "id") String accountNumber){
        Object data = adminuserService.queryOneUserById(accountNumber);
        if(data != null){
            return JsonResult.build(STATUS_SUCCEED, MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(MSG_FAIL);
    }
}
