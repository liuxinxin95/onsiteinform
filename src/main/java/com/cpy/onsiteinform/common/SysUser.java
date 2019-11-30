package com.cpy.onsiteinform.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Carl
 * @ClassName SysUser
 * @Description
 * @date 2019-09-30 10:53
 **/
@Data
public class SysUser implements Serializable {

    private String userName;

    private Long userId;

    private String mobile;

}
