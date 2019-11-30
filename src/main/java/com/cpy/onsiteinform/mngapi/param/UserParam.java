package com.cpy.onsiteinform.mngapi.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName UserVO
 * @Description
 * @date 2019-09-08 15:37
 **/
@Data
@ApiModel
public class UserParam implements Serializable {

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String mobile;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

}
