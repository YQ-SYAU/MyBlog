package com.syau.domain;

/**
 * 点赞
 */
public class Support {
    /**
     * id varchar(200)comment '点赞id',
     * uId varchar(200) comment '用户id',
     * aId varchar(200) comment '文章id',
     */
    private String id;
    private String uId;
    private String aId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }
}
