package com.cpy.onsiteinform.center.cpy.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cpy_article_browse")
public class CpyArticleBrowseDO {
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 浏览数
     */
    @Column(name = "browse_num")
    private Integer browseNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取浏览数
     *
     * @return browse_num - 浏览数
     */
    public Integer getBrowseNum() {
        return browseNum;
    }

    /**
     * 设置浏览数
     *
     * @param browseNum 浏览数
     */
    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}