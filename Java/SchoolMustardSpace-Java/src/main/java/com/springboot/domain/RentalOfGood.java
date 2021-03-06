package com.springboot.domain;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/26
 * @description:物品租赁的pojo类
 * TODO:
 */

public class RentalOfGood {
    private String id;              //标识码
    private int userId;             //用户id
    private String title;           //文章标题
    private String content;         //文章内容
    private String image;           //图片地址
    private String label;           //标签
    private String location;        //定位地点
    private int isDone = 0;             //是否做完
    private String unitPrice;       //价格
    private String startTime = "0";       //开始时间
    private String endTime = "0";         //结束时间
    private int newDegree;          //新旧程度
    private int thumbUp = 0;            //点赞数
    private int collect = 0;            //收藏数
    private int comment = 0;            //评论数

    @Override
    public String toString() {
        return "RentalOfGood{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", label='" + label + '\'' +
                ", location='" + location + '\'' +
                ", isDone=" + isDone +
                ", unitPrice='" + unitPrice + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", newDegree=" + newDegree +
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNewDegree() {
        return newDegree;
    }

    public void setNewDegree(int newDegree) {
        this.newDegree = newDegree;
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
