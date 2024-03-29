package com.cpy.onsiteinform.mngapi.cpy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@ApiModel
@Data
public class CpyProjectVO {


    /**
     *
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keyword;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String digest;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private List<String> picList;

    /**
     * 成功案例网站
     */
    @ApiModelProperty(value = "成功案例网站")
    private String succeedUrl;

    /**
     * 是否公开
     */
    @ApiModelProperty(value = "是否公开")
    private Boolean isOpen;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String pwds;

    /**
     * pc
     */
    @ApiModelProperty(value = "pc")
    private Boolean pc;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    private Boolean iphone;

    /**
     * 平板
     */
    @ApiModelProperty(value = "平板")
    private Boolean ipad;

    /**
     * 成功案例网站
     */
    @ApiModelProperty(value = "pc成功案例网站")
    private String pcUrl;

    /**
     * 成功案例网站
     */
    @ApiModelProperty(value = "收集成功案例网站")
    private String iphoneUrl;

    /**
     * 成功案例网站
     */
    @ApiModelProperty(value = "平板成功案例网站")
    private String ipadUrl;

    /**
     * 状态：0待审核1已发布
     */
    @ApiModelProperty(value = "状态：0待审核1已发布")
    private Integer status;
    /**
     * 分类id集合
     */
    @ApiModelProperty(value = "分类id集合")
    private List<String> categoryIdList;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "浏览量")
    private Integer browseNum;
}
