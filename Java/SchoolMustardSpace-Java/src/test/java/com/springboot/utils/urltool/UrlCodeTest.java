package com.springboot.utils.urltool;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;


/**
 * @author 会飞的大野鸡
 * @create 2020/5/6
 * TODO:
 */

public class UrlCodeTest {
    @Test
    public void urlEncode() {
        String code = "%E6%9D%8E%E7%9F%A5%E6%81%A9%E6%88%91%E8%80%81%E5%A9%86";
        code.toUpperCase();
        try {
            Assert.assertEquals(code , new UrlCode().urlEncode("李知恩我老婆"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
