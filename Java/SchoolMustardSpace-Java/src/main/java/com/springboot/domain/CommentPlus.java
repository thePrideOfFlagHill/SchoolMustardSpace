package com.springboot.domain;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/6
 * TODO:
 */

public class CommentPlus extends Comment {
    private String name;
    private String accountNumber;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
