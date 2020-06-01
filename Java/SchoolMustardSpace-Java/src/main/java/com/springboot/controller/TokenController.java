package com.springboot.controller;

import com.springboot.config.UserLoginToken;
import com.springboot.domain.User;
import com.springboot.service.TokenService;
import com.springboot.service.UserService;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.tokentool.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class TokenController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    // 登录
    @GetMapping("/login")
    public JsonResult login(User user, HttpServletResponse response) {

        User userForBase = new User();
        userForBase.setId(1);
        userForBase.setPassword("test");
        userForBase.setAccountNumber("test");

        if (!userForBase.getPassword().equals(user.getPassword())) {
            return JsonResult.errorMsg("密码错误");
        } else {
            String token = tokenService.getToken(userForBase);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return JsonResult.ok(token);

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
}
