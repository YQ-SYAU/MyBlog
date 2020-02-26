package com.syau.domain;

//关注
public class Attention {

    /**
     * id varchar(200) comment '关注id',
     * u_id varchar(200) comment '用户id',
     * p_id varchar(200) comment '被关注人id',
     */
    private String id;
    private UserInfo myself;//用户
    private UserInfo other;//被关注者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getMyself() {
        return myself;
    }

    public void setMyself(UserInfo myself) {
        this.myself = myself;
    }

    public UserInfo getOther() {
        return other;
    }

    public void setOther(UserInfo other) {
        this.other = other;
    }
}
