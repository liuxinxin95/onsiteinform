package com.cpy.onsiteinform.center.user.service.impl;

import com.cpy.onsiteinform.center.user.entity.MngSysUserDO;
import com.cpy.onsiteinform.center.user.mapper.MngSysUserDOMapper;
import com.cpy.onsiteinform.center.user.service.MngUserService;
import com.cpy.onsiteinform.common.SysUser;
import com.cpy.onsiteinform.exception.RRException;
import com.cpy.onsiteinform.mngapi.param.UserParam;
import com.cpy.onsiteinform.mngapi.vo.LoginVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.cpy.onsiteinform.util.JwtUtil;
import com.cpy.onsiteinform.util.MD5;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName MngUserServiceImpl
 * @Description
 * @date 2019-11-30 23:13
 **/
@Service
@Primary
public class MngUserServiceImpl implements MngUserService {

    @Resource
    private MngSysUserDOMapper mngSysUserDOMapper;


    /**
     * 登录
     *
     * @param userVO
     * @return
     */
    @Override
    public LoginVO login(UserParam userVO) {
        MngSysUserDO userDO = new MngSysUserDO();
        userDO.setMobile(userVO.getMobile());
        userDO.setPassword(MD5.encoderByMd5(userVO.getPassword()));
        MngSysUserDO sysUserDO = mngSysUserDOMapper.selectOne(userDO);
        if (sysUserDO == null) {
            throw new RRException("用户或密码错误");
        }
        SysUser sysUser = BeanMapUtil.convertObject(sysUserDO, SysUser.class);
        sysUser.setMobile(sysUserDO.getMobile());
        String jwt = JwtUtil.generateToken(sysUser);
        LoginVO loginVO = new LoginVO();
        loginVO.setSession(jwt);
        return loginVO;
    }
}
