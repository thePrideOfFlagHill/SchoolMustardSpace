package com.springboot.constant;

/**
 * LostFoundCommentConstant
 * TODO
 * @description 失物招领评论常量接口 LostFoundCommentConstant
 * @author 221701429_黄晓东
 * @version v 1.0.0
 * @since 2020.5.30
 */
public interface LostFoundCommentConstant {
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
