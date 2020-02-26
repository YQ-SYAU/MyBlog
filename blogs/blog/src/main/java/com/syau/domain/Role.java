package com.syau.domain;

import java.util.Set;

/**
 * 角色
 */
public class Role {
    /*id varchar(200)comment 'id,无明确意义' ,
        roleName varchar(50)comment '角色名',*/
    private String id;
    private String roleName;
    private Set<UserInfo> users;//角色分配给哪些用户
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserInfo> users) {
        this.users = users;
    }
}
