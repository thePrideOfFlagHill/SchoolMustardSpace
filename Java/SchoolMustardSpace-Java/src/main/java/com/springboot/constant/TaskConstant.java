package com.springboot.constant;

/**
 * TaskConstant
 * TODO
 * @description 任务常量接口 TaskConstant
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.30
 */
public interface TaskConstant {

    //初始化完成状态
    int INIT_DONE = 0;

    //初始化点赞
    int INIT_THUMB = 0;

    //初始化收藏
    int INIT_COLLECT = 0;

    //初始化评论
    int INIT_COMMENT = 0;

    //sql语句失败的返回
    int SQL_FAIL = 0;

    //失败的返回
    String MSG_FAIL = "fail";

    //成功的返回
    String MSG_SUCCEED = "succeed";

    int STATUS_SUCCEED = 200;
}
    