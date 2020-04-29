package com.springboot.controller;

import com.springboot.domain.Adminuser;
import com.springboot.service.AdminuserService;
import com.springboot.utils.jsontool.JsonResult;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RequestMapping(value = "/api/admin")
public class AdminuserController {
    @Resource
    private AdminuserService adminuserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestParam(value = "accountNumber") String accountNumber,
                            @RequestParam(value = "password") String password){
        String msg = adminuserService.login(accountNumber, password);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody Adminuser adminuser){
        String msg = adminuserService.register(adminuser);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/find/password", method = RequestMethod.POST)
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                                   @RequestParam(value = "newPassword") String newPassword){
        String msg = adminuserService.findPassword(accountNumber, newPassword);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/update/password", method = RequestMethod.POST)
    public JsonResult changePassword(@RequestParam(value = "accountNumber") String accountNumber,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "newPassword") String newPassword){
        String msg = adminuserService.changePassword(accountNumber, password, newPassword);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult updateAdminuserMessage(@RequestBody Adminuser adminuser){
        String msg = adminuserService.updateAdminuserMessage(adminuser);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonResult deleteAdminuser(@RequestParam(value = "accountNumber") String accountNumber){
        String msg = adminuserService.deleteAdminuser(accountNumber);
        if(msg.equals("succeed")){
            return JsonResult.build(200, msg, null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public JsonResult queryAllAdminuser(){
        Object data = adminuserService.queryAllAdminuser();
        if(data != null){
            return JsonResult.build(200, "succeed", data);
        }
        else return JsonResult.errorMsg("fail");
    }

    @RequestMapping(value = "/query/accountNumber/{accountNumber}", method = RequestMethod.GET)
    public JsonResult queryOneAdminuser(@PathVariable(value = "accountNumber") String accountNumber){
        Object data = adminuserService.queryOneAdminuser(accountNumber);
        if(data != null){
            return JsonResult.build(200, "succeed", data);
        }
        else return JsonResult.errorMsg("fail");
    }
}
