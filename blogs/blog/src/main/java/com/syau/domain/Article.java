package com.syau.domain;
//文章实体
public class Article {
    /*id varchar(200) comment 'id,无明确意义',
        title varchar(30) comment '文章标题',
        content varchar(600) comment '文章内容',
        picture varchar(200) comment '文章图片路径',
        support int(10) comment '文章点赞总数',
        publishTime varchar(50) comment '文章发布时间',
        browse int(10) comment '文章浏览量',
        u_id varchar(200) comment '发布人用户id',
        c_id varchar(200) comment '所属分类',
        commentNum int(10) comment '文章评论数',*/
    private String id;
    private String title;
    private String content;
    private String picture;
    private Integer support;
    private String publishTime;
    private Integer browse;
    private UserInfo user;
    private Category category;
    private Integer commentNum;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", support=" + support +
                ", publishTime='" + publishTime + '\'' +
                ", browse=" + browse +
                ", user=" + user +
                ", category=" + category +
                ", commentNum=" + commentNum +
                '}';
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getSupport() {
        return support;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
