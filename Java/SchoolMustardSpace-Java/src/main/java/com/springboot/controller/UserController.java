package com.springboot.controller;

import com.springboot.config.UserLoginToken;
import com.springboot.constant.UserConstant;
import com.springboot.domain.User;
import com.springboot.service.TokenService;
import com.springboot.service.UserService;
import com.springboot.utils.encryptiontool.DesEncryption;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.tokentool.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private TokenService tokenService;

    /*@PostMapping("/login")
    public JsonResult login(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.login(user.getAccountNumber(), str);
        //int id = userService.selectId(user.getAccountNumber());

        //登录成功返回用户基本信息
        if(msg.equals(MSG_SUCCEED)){
            User user1 = userService.queryOneUser(user.getAccountNumber());
            return JsonResult.build(STATUS_SUCCEED,msg,user1);
        }
        else return JsonResult.errorMsg(msg);
    }*/

    //增加token
    @PostMapping("/login")
    public JsonResult login(@RequestParam(value = "accountNumber") String accountNumber,
                            @RequestParam(value = "password") String password,
                            HttpServletResponse response){
        //对传入的user密码进行加密处理
        byte[] secretArr = DesEncryption.encryptMode(password.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.login(accountNumber, str);

        //从数据库中取出传入的accountNumber对应的实体
        User tempUser = userService.queryOneUser(accountNumber);
        if(msg.equals(MSG_FAIL)){
            return JsonResult.errorMsg(msg);
        }
        else{
            String token = tokenService.getToken(tempUser);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            tempUser.setToken(token);

            return JsonResult.build(STATUS_SUCCEED, msg, tempUser);
        }

    }

    /***
     * 这个请求需要验证token才能访问
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "你已通过验证";
    }

    @PostMapping("/register")
    public JsonResult register(@RequestBody User user){
        byte[] secretArr = DesEncryption.encryptMode(user.getPassword().getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        user.setPassword(str);
        String msg = userService.register(user);

        //注册成功时返回id
        if(msg.equals(MSG_SUCCEED)){
            int id = userService.selectId(user.getAccountNumber());
            return JsonResult.build(STATUS_SUCCEED,msg,id);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/find/password")
    public JsonResult findPassword(@RequestParam(value = "accountNumber") String accountNumber,
                                   @RequestParam(value = "phoneNumber") String phoneNumber,
                                   @RequestParam(value = "newPassword") String newPassword){
        byte[] secretArr = DesEncryption.encryptMode(newPassword.getBytes());
        String str = DesEncryption.byte2Hex(secretArr);
        String msg = userService.findPassword(accountNumber, phoneNumber, str);
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
