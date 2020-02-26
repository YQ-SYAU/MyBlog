package com.syau.domain;

//点赞
public class Comments {
    /**
     *  id varchar(200)comment '评论id',
     *     u_id varchar(200) comment '用户id',
     *     a_id varchar(200) comment '文章id',
     *     c_time varchar(50) comment'评论时间',
     *     content varchar(600) comment '评论内容',
     */
    private String id;
    private UserInfo userInfo;
    private String aId;
    private String cTime;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
