package com.syau.domain;
//分类
public class Category {
//    id varchar(200) comment 'id,无明确意义',
//    cname varchar(20) comment '分类名称',
    private String id;
    private String cname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
