package com.syau.domain;
//轮播图
public class Slideshow {
    /*id VARCHAR(32) PRIMARY KEY comment '轮播图id,无明确意义'
    picture1 varchar(200),
    picture2 varchar(200),
    picture3 varchar(200)*/
    private String id;
    private String picture1;
    private String picture2;
    private String picture3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }
}
