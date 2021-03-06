package com.springboot.domain;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:失物招领pojo类
 * TODO:
 */

public class LostAndFound {
    private String id;              //标识码
    private int userId;             //用户id
    private String title;           //文章标题
    private String content;         //文章内容
    private String image = null;    //图片地址
    private String label;           //标签
    private String location;        //定位地点
    private int isDone = 0;         //是否做完
    private String time;            //时间
    private int isLost;             //为丢失还是招领.0为丢失，1为招领
    private int thumbUp = 0;        //点赞数
    private int collect = 0;        //收藏数
    private int comment = 0;        //评论数

    @Override
    public String toString() {
        return "LostAndFound{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", label='" + label + '\'' +
                ", location='" + location + '\'' +
                ", isDone=" + isDone +
                ", time='" + time + '\'' +
                ", isLost=" + isLost +
                ", thumbUp=" + thumbUp +
                ", collect=" + collect +
                ", comment=" + comment +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIsLost() {
        return isLost;
    }

    public void setIsLost(int isLost) {
        this.isLost = isLost;
    }

    public int getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(int thumbUp) {
        this.thumbUp = thumbUp;
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
