package com.springboot.domain;

/**
 * Adminuser
 * TODO
 * @description Adminuser对应的实体类
 * @author 221701419_黄晓东
 * @version v 1.0.0
 * @since 2020/4/26
 */
public class Adminuser {
    private int id;
    private String accountNumber;//管理员账号
    private String password;//管理员密码
    private int authority;//管理员权限

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getAuthority() {
        return authority;
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

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
