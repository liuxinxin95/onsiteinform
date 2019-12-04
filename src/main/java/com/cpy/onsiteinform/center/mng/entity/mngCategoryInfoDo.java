package com.cpy.onsiteinform.center.mng.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mng_category_info")
public class mngCategoryInfoDo {
    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 上级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

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
     * 获取分类名
     *
     * @return name - 分类名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名
     *
     * @param name 分类名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级ID
     *
     * @return parent_id - 上级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId 上级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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