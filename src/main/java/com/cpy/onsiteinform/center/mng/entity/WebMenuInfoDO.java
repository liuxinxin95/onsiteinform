package com.cpy.onsiteinform.center.mng.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_menu_info")
public class WebMenuInfoDO {
    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 导航名称
     */
    private String name;

    /**
     * 图片
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 连接地址
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 是否有效:1-有效 0-无效
     */
    private Boolean valid;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private Long createUser;

    /**
     * 更新者
     */
    @Column(name = "update_user")
    private Long updateUser;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取导航名称
     *
     * @return name - 导航名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置导航名称
     *
     * @param name 导航名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取图片
     *
     * @return pic_url - 图片
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片
     *
     * @param picUrl 图片
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取连接地址
     *
     * @return link_url - 连接地址
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置连接地址
     *
     * @param linkUrl 连接地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * 获取是否有效:1-有效 0-无效
     *
     * @return valid - 是否有效:1-有效 0-无效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 设置是否有效:1-有效 0-无效
     *
     * @param valid 是否有效:1-有效 0-无效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者
     *
     * @return create_user - 创建者
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建者
     *
     * @param createUser 创建者
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取更新者
     *
     * @return update_user - 更新者
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新者
     *
     * @param updateUser 更新者
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}