package com.cpy.onsiteinform.mngapi.onsite.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel
public class MngContentInfoVO implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 一级分类ID
     */
    @ApiModelProperty(value = "一级分类ID")
    private Integer topCategoryId;

    /**
     * 分类ID
     */
    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图")
    private String breviaryPic;

    /**
     * 中文演示地址
     */
    @ApiModelProperty(value = "中文演示地址")
    private String zhDemoUrl;

    /**
     * 英文演示地址
     */
    @ApiModelProperty(value = "英文演示地址")
    private String egDemoUrl;

    /**
     * 百度网盘地址
     */
    @ApiModelProperty(value = "百度网盘地址")
    private String baiduNetdiskUrl;

    /**
     * 百度网盘密码
     */
    @ApiModelProperty(value = "百度网盘密码")
    private String baiduNetdiskPwd;

    /**
     * seo关键字
     */
    @ApiModelProperty(value = "seo关键字")
    private String seoKeyword;

    /**
     * seo标题
     */
    @ApiModelProperty(value = "seo标题")
    private String seoTitle;

    /**
     * seo描述
     */
    @ApiModelProperty(value = "seo描述")
    private String seoDigest;

    /**
     * 标签集合
     */
    @ApiModelProperty(value = "标签集合")
    private List<String> tagList;

    /**
     * 状态：0待审核1已发布
     */
    @ApiModelProperty(value = "状态：0待审核1已发布")
    private Integer status;

    /**
     * 是否删除：1删除 0未删除
     */
    @ApiModelProperty(value = "是否删除：1删除 0未删除")
    private Boolean disable;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private Long createUser;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private Long updateUser;

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
     * 获取一级分类ID
     *
     * @return top_category_id - 一级分类ID
     */
    public Integer getTopCategoryId() {
        return topCategoryId;
    }

    /**
     * 设置一级分类ID
     *
     * @param topCategoryId 一级分类ID
     */
    public void setTopCategoryId(Integer topCategoryId) {
        this.topCategoryId = topCategoryId;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取缩略图
     *
     * @return breviary_pic - 缩略图
     */
    public String getBreviaryPic() {
        return breviaryPic;
    }

    /**
     * 设置缩略图
     *
     * @param breviaryPic 缩略图
     */
    public void setBreviaryPic(String breviaryPic) {
        this.breviaryPic = breviaryPic == null ? null : breviaryPic.trim();
    }

    /**
     * 获取中文演示地址
     *
     * @return zh_demo_url - 中文演示地址
     */
    public String getZhDemoUrl() {
        return zhDemoUrl;
    }

    /**
     * 设置中文演示地址
     *
     * @param zhDemoUrl 中文演示地址
     */
    public void setZhDemoUrl(String zhDemoUrl) {
        this.zhDemoUrl = zhDemoUrl == null ? null : zhDemoUrl.trim();
    }

    /**
     * 获取英文演示地址
     *
     * @return eg_demo_url - 英文演示地址
     */
    public String getEgDemoUrl() {
        return egDemoUrl;
    }

    /**
     * 设置英文演示地址
     *
     * @param egDemoUrl 英文演示地址
     */
    public void setEgDemoUrl(String egDemoUrl) {
        this.egDemoUrl = egDemoUrl == null ? null : egDemoUrl.trim();
    }

    /**
     * 获取百度网盘地址
     *
     * @return baidu_netdisk_url - 百度网盘地址
     */
    public String getBaiduNetdiskUrl() {
        return baiduNetdiskUrl;
    }

    /**
     * 设置百度网盘地址
     *
     * @param baiduNetdiskUrl 百度网盘地址
     */
    public void setBaiduNetdiskUrl(String baiduNetdiskUrl) {
        this.baiduNetdiskUrl = baiduNetdiskUrl == null ? null : baiduNetdiskUrl.trim();
    }

    /**
     * 获取百度网盘密码
     *
     * @return baidu_netdisk_pwd - 百度网盘密码
     */
    public String getBaiduNetdiskPwd() {
        return baiduNetdiskPwd;
    }

    /**
     * 设置百度网盘密码
     *
     * @param baiduNetdiskPwd 百度网盘密码
     */
    public void setBaiduNetdiskPwd(String baiduNetdiskPwd) {
        this.baiduNetdiskPwd = baiduNetdiskPwd == null ? null : baiduNetdiskPwd.trim();
    }

    /**
     * 获取seo关键字
     *
     * @return seo_keyword - seo关键字
     */
    public String getSeoKeyword() {
        return seoKeyword;
    }

    /**
     * 设置seo关键字
     *
     * @param seoKeyword seo关键字
     */
    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword == null ? null : seoKeyword.trim();
    }

    /**
     * 获取seo标题
     *
     * @return seo_title - seo标题
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * 设置seo标题
     *
     * @param seoTitle seo标题
     */
    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    /**
     * 获取seo描述
     *
     * @return seo_digest - seo描述
     */
    public String getSeoDigest() {
        return seoDigest;
    }

    /**
     * 设置seo描述
     *
     * @param seoDigest seo描述
     */
    public void setSeoDigest(String seoDigest) {
        this.seoDigest = seoDigest == null ? null : seoDigest.trim();
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
     * 获取是否删除：1删除 0未删除
     *
     * @return disable - 是否删除：1删除 0未删除
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * 设置是否删除：1删除 0未删除
     *
     * @param disable 是否删除：1删除 0未删除
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
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

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}