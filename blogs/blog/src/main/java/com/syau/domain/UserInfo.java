package com.syau.domain;

import java.util.Set;

public class UserInfo {
    /*id varchar(200) comment 'id,无明确意义',
        username varchar(20) comment '用户名',
        password varchar(100) comment '密码',
        qq varchar(20) comment '用户qq号',
        gender varchar(20) comment '性别',
        picture varchar(200) comment '用户头像保存路径',
        description varchar(300) comment '个人描述',
        fans int(10) comment '粉丝数目',
        status int(10)comment '用户状态：1 可用；0 不可用',
        */
    private String id;
    private String username;
    private String password;
    private String qq;
    private String gender;
    private String picture;
    private String description;
    private Integer fans;
    private Integer status;
    private String statusStr;//用户状态字符串表示
    private Set<Role> roles;//用户拥有的角色

    public String getStatusStr() {
        if(status==0){
            statusStr = "不可用";
        }else{
            statusStr = "可用";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
