package com.cpy.onsiteinform.center.mng.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mng_tag_info")
public class mngTagInfoDo {
    @Id
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取别名
     *
     * @return alias - 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置别名
     *
     * @param alias 别名
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
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