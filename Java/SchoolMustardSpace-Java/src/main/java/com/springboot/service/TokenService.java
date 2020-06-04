package com.springboot.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.springboot.domain.Adminuser;
import com.springboot.domain.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("TokenService")
public class TokenService {

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        //System.out.println(String.valueOf(user.getId()));
        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String getToken(Adminuser adminuser) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        //System.out.println(String.valueOf(user.getId()));

        token = JWT.create().withAudience(String.valueOf(adminuser.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(adminuser.getPassword()));
        return token;
    }
}