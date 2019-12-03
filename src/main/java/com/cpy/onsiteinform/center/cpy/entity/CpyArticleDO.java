package com.cpy.onsiteinform.center.cpy.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cpy_article")
public class CpyArticleDO {
    @Id
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 标签集合
     */
    private String tags;

    /**
     * 状态：0待审核1已发布
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 图片
     */
    @Column(name = "pics")
    private String pics;

    /**
     * 分类id集合
     */
    @Column(name = "category_ids")
    private String categoryIds;
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取关键字
     *
     * @return keyword - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置关键字
     *
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 获取摘要
     *
     * @return digest - 摘要
     */
    public String getDigest() {
        return digest;
    }

    /**
     * 设置摘要
     *
     * @param digest 摘要
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    /**
     * 获取标签集合
     *
     * @return tags - 标签集合
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签集合
     *
     * @param tags 标签集合
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * 获取状态：0待审核1已发布
     *
     * @return status - 状态：0待审核1已发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0待审核1已发布
     *
     * @param status 状态：0待审核1已发布
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }
}