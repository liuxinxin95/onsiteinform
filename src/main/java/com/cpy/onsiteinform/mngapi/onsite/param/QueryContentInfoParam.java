package com.cpy.onsiteinform.mngapi.onsite.param;

import com.cpy.onsiteinform.common.PageRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Carl
 * @ClassName QueryContentInfoParam
 * @Description
 * @date 2019-12-08 11:23
 **/
@Data
@ApiModel
public class QueryContentInfoParam extends PageRequest {

    /**
     * 状态：0待审核1已发布
     */
    @ApiModelProperty(value = "状态：0待审核1已发布")
    private Integer status;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "一级分类id")
    private Integer topCategoryId;

    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date queryStartTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date queryEndTime;
}
