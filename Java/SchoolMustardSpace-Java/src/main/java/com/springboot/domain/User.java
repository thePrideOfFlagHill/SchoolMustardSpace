package com.springboot.domain;

import javax.persistence.Column;

/**
 * User
 * TODO
 * @description User对应的实体类
 * @author 221701419_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
public class User {
    private int id;

    private String accountNumber;//用户账号

    private String password;//用户密码

    private int sex;//性别

    private String name;//姓名

    private String phoneNumber;//手机号

    private String head;//头像

    private String address;//地址

    private String info;//详细信息

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHead() {
        return head;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
