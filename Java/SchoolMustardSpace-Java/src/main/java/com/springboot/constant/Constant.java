package com.springboot.constant;

/**
 * ProvinceConstant
 * TODO
 * @description 常量接口 Constant
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
public interface Constant {
    //失败的返回
    String MSG_FAIL = "fail";

    //成功的返回
    String MSG_SUCCEED = "succeed";

    //成功时返回的STATUS值
    int STATUS_SUCCEED = 200;

    //sql语句失败的返回
    int SQL_FAIL = 0;

    //初始化点赞
    int INIT_THUMB = 0;

    //初始化评论
    int INIT_COMMENT = 0;
}
    