package com.cpy.onsiteinform.center.user.service;

import com.cpy.onsiteinform.mngapi.param.UserParam;
import com.cpy.onsiteinform.mngapi.vo.LoginVO;

/**
 * @author Carl
 * @ClassName MngUserService
 * @Description
 * @date 2019-11-30 23:13
 **/
public interface MngUserService {

    /**
     * 登录
     * @param userVO
     * @return
     */
    LoginVO login(UserParam userVO);
}
