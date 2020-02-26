package com.syau.domain;

/**
 * 系统日志类
 */
public class SysLog {
    /**
     *   id VARCHAR(32) PRIMARY KEY comment '用户id',
     *     visitTime varchar(100) comment '访问时间',
     *     username VARCHAR(50) comment '用户名',
     *     ip VARCHAR(30) comment 'ip地址',
     *     url VARCHAR(50) comment '访问的路径',
     *     executionTime int comment '执行所花的时间',
     *     method VARCHAR(200) comment '访问的方法'
     */
    private String id;
    private String visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
