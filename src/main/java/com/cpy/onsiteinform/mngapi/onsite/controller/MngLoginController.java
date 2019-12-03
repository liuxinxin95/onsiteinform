package com.cpy.onsiteinform.mngapi.onsite.controller;

import com.cpy.onsiteinform.center.user.service.MngUserService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.onsite.param.UserParam;
import com.cpy.onsiteinform.mngapi.onsite.vo.LoginVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName MngLoginController
 * @Description
 * @date 2019-11-30 23:11
 **/
@RestController
@RequestMapping("mng/api/login")
public class MngLoginController extends BaseController {

    @Resource
    private MngUserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "获取用户信息")
    @ResponseBody
    public ApiResponse<LoginVO> login(@RequestBody UserParam userVO) {
        return success(userService.login(userVO));
    }
}
