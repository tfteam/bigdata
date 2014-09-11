package com.bigdata.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by log on 14-4-4.
 */
public class UserBehaviorDO extends BaseDO implements Serializable {

    /**
     * 用户主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 新闻ID
     */
    private long newsId;
    /**
     * 浏览时间
     */
    private Date scanTime;
    /**
     * 标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容
     */
    private String content;
    /**
     * 新闻发表时间
     */
    private Date publishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }


}
