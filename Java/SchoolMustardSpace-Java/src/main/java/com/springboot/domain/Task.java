package com.springboot.domain;

/**
 * Task
 * TODO
 * @description Task对应的实体类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
public class Task {

    //条目id
    private String id;

    //用户id（外键）
    private int user_id;

    //标题
    private String title;

    //描述内容
    private String content;

    //图片地址
    private String image;

    //标签
    private String label;

    //坐标地址
    private String location;

    //判断任务是否完成，只能取0或1，0未完成，1为完成
    private int is_done;

    //酬劳
    private String reword;

    //开始时间
    private String start_time;

    //开始时间
    private String end_time;

    //点赞数
    private int thumb_up;

    //收藏数
    private int collect;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIs_done() {
        return is_done;
    }

    public void setIs_done(int is_done) {
        this.is_done = is_done;
    }

    public String getReword() {
        return reword;
    }

    public void setReword(String reword) {
        this.reword = reword;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getThumb_up() {
        return thumb_up;
    }

    public void setThumb_up(int thumb_up) {
        this.thumb_up = thumb_up;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
    