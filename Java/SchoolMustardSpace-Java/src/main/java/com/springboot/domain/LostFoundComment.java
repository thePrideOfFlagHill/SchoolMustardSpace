package com.springboot.domain;

/**
 * LostFoundComment
 * TODO
 * @description LostFoundComment对应的实体类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.5.1
 */
public class LostFoundComment {

    //条目id
    private String id;

    //用户id（外键）
    private int user_id;

    //内容
    private String content;

    //发布时间
    private String publish_time;

    //对应表的条目id（外键）
    private String table_id;

    //点赞数
    private int thumb_up;

    //评论数
    private int comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getTable_id() {
        return table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public int getThumb_up() {
        return thumb_up;
    }

    public void setThumb_up(int thumb_up) {
        this.thumb_up = thumb_up;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
    