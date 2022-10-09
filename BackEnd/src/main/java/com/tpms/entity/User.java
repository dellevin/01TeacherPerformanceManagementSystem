package com.tpms.entity;

import java.util.Date;

public class User {
    private Integer uid;//主键id
    private String name;//姓名
    private String phone;//电话
    private Integer age;//年龄
    //性别    0女  1男
    private Integer sex;
    private String username;//用户名
    private String password;//密码
    //启用状态  1启用 2注销
    private Integer status;
    private String createtime;//创建时间
    //角色    1管理员    2总经理    3普通用户，管理员才可以登录后台系统！
    private Integer role;
    private String picture;//头像

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User() {
    }
    //后台登录时，保存用户信息的构造方法
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createtime=" + createtime +
                ", role=" + role +
                ", picture='" + picture + '\'' +
                '}';
    }
}
