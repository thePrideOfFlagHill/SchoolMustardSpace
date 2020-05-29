package com.springboot.controller;

import com.springboot.constant.Constant;
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
 * TODO
 * @description 所有有关管理员操作的接口
 *
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.4.29
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/admin")
public class AdminuserController {
    @Resource
    private AdminuserService adminuserService;

    @PostMapping("/login")
    public JsonResult login(@RequestBody Adminuser adminuser){
        byte[] secretArr = DesEncryption.encryptMode(adminuser.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        adminuser.setPassword(str);
        String msg = adminuserService.login(adminuser);
        int id = adminuserService.selectId(adminuser.getAccountNumber());
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, id);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/register")
    public JsonResult register(@RequestBody Adminuser adminuser){
        byte[] secretArr = DesEncryption.encryptMode(adminuser.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        adminuser.setPassword(str);
        String msg = adminuserService.register(adminuser);
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/find/password")
    public JsonResult findPassword(@RequestBody Map<String, String> map){

        byte[] secretArr = DesEncryption.encryptMode(map.get("newPassword").getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = adminuserService.findPassword(map.get("accountNumber"), str);
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update/password")
    public JsonResult changePassword(@RequestBody Map<String, String> map){
        byte[] secretArr1 = DesEncryption.encryptMode(map.get("password").getBytes());
        byte[] secretArr2 = DesEncryption.encryptMode(map.get("newPassword").getBytes());
        String str1 = DesEncryption.byte2Hex(secretArr1);
        String str2 = DesEncryption.byte2Hex(secretArr2);
        String msg = adminuserService.changePassword(map.get("accountNumber"), str1, str2);
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update")
    public JsonResult updateAdminuserMessage(@RequestBody Adminuser adminuser){
        byte[] secretArr = DesEncryption.encryptMode(adminuser.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        adminuser.setPassword(str);
        String msg = adminuserService.updateAdminuserMessage(adminuser);
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete")
    public JsonResult deleteAdminuser(@RequestBody Map<String, String> map){
        String msg = adminuserService.deleteAdminuser(map.get("accountNumber"));
        if(msg.equals(Constant.MSG_SUCCEED)){
            return JsonResult.build(Constant.STATUS_SUCCEED, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/query/all")
    public JsonResult queryAllAdminuser(){
        Object data = adminuserService.queryAllAdminuser();
        if(data != null){
            return JsonResult.build(Constant.STATUS_SUCCEED, Constant.MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(Constant.MSG_FAIL);
    }

    @GetMapping("/query/accountNumber/{accountNumber}")
    public JsonResult queryOneAdminuser(@PathVariable(value = "accountNumber") String accountNumber){
        Object data = adminuserService.queryOneAdminuser(accountNumber);
        if(data != null){
            return JsonResult.build(Constant.STATUS_SUCCEED, Constant.MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(Constant.MSG_FAIL);
    }

    @GetMapping("/query/id/{id}")
    public JsonResult queryOneUserById(@PathVariable(value = "id") String accountNumber){
        Object data = adminuserService.queryOneUserById(accountNumber);
        if(data != null){
            return JsonResult.build(Constant.STATUS_SUCCEED, Constant.MSG_SUCCEED, data);
        }
        else return JsonResult.errorMsg(Constant.MSG_FAIL);
    }
}
