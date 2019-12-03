package com.cpy.onsiteinform.center.cpy.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cpy_project")
public class CpyProjectDO {
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
     * 成功案例网站
     */
    @Column(name = "succeed_url")
    private String succeedUrl;

    /**
     * 是否公开
     */
    @Column(name = "is_open")
    private Byte isOpen;

    /**
     * 密码
     */
    private String pwds;

    /**
     * pc
     */
    private Byte pc;

    /**
     * 手机
     */
    private Byte iphone;

    /**
     * 平板
     */
    private Byte ipad;

    /**
     * 成功案例网站
     */
    @Column(name = "pc_url")
    private String pcUrl;

    /**
     * 成功案例网站
     */
    @Column(name = "iphone_url")
    private String iphoneUrl;

    /**
     * 成功案例网站
     */
    @Column(name = "ipad_url")
    private String ipadUrl;

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
     * 获取成功案例网站
     *
     * @return succeed_url - 成功案例网站
     */
    public String getSucceedUrl() {
        return succeedUrl;
    }

    /**
     * 设置成功案例网站
     *
     * @param succeedUrl 成功案例网站
     */
    public void setSucceedUrl(String succeedUrl) {
        this.succeedUrl = succeedUrl == null ? null : succeedUrl.trim();
    }

    /**
     * 获取是否公开
     *
     * @return is_open - 是否公开
     */
    public Byte getIsOpen() {
        return isOpen;
    }

    /**
     * 设置是否公开
     *
     * @param isOpen 是否公开
     */
    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 获取密码
     *
     * @return pwds - 密码
     */
    public String getPwds() {
        return pwds;
    }

    /**
     * 设置密码
     *
     * @param pwds 密码
     */
    public void setPwds(String pwds) {
        this.pwds = pwds == null ? null : pwds.trim();
    }

    /**
     * 获取pc
     *
     * @return pc - pc
     */
    public Byte getPc() {
        return pc;
    }

    /**
     * 设置pc
     *
     * @param pc pc
     */
    public void setPc(Byte pc) {
        this.pc = pc;
    }

    /**
     * 获取手机
     *
     * @return iphone - 手机
     */
    public Byte getIphone() {
        return iphone;
    }

    /**
     * 设置手机
     *
     * @param iphone 手机
     */
    public void setIphone(Byte iphone) {
        this.iphone = iphone;
    }

    /**
     * 获取平板
     *
     * @return ipad - 平板
     */
    public Byte getIpad() {
        return ipad;
    }

    /**
     * 设置平板
     *
     * @param ipad 平板
     */
    public void setIpad(Byte ipad) {
        this.ipad = ipad;
    }

    /**
     * 获取成功案例网站
     *
     * @return pc_url - 成功案例网站
     */
    public String getPcUrl() {
        return pcUrl;
    }

    /**
     * 设置成功案例网站
     *
     * @param pcUrl 成功案例网站
     */
    public void setPcUrl(String pcUrl) {
        this.pcUrl = pcUrl == null ? null : pcUrl.trim();
    }

    /**
     * 获取成功案例网站
     *
     * @return iphone_url - 成功案例网站
     */
    public String getIphoneUrl() {
        return iphoneUrl;
    }

    /**
     * 设置成功案例网站
     *
     * @param iphoneUrl 成功案例网站
     */
    public void setIphoneUrl(String iphoneUrl) {
        this.iphoneUrl = iphoneUrl == null ? null : iphoneUrl.trim();
    }

    /**
     * 获取成功案例网站
     *
     * @return ipad_url - 成功案例网站
     */
    public String getIpadUrl() {
        return ipadUrl;
    }

    /**
     * 设置成功案例网站
     *
     * @param ipadUrl 成功案例网站
     */
    public void setIpadUrl(String ipadUrl) {
        this.ipadUrl = ipadUrl == null ? null : ipadUrl.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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