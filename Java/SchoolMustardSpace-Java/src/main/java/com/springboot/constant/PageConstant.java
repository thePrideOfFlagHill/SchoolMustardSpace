package com.springboot.constant;

/**
 * PageConstant
 * TODO
 * @description 分页常量接口 PageConstant
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.6.4
 */
public interface PageConstant {

    //页的长度
    int PAGE_SIZE = 15;

    //失败的返回
    String MSG_FAIL = "fail";

    //成功的返回
    String MSG_SUCCEED = "succeed";

    //成功返回标志
    int STATUS_SUCCEED = 200;
}
