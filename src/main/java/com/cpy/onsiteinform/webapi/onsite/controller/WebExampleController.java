package com.cpy.onsiteinform.webapi.onsite.controller;

import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl
 * @ClassName ExampleController
 * @Description
 * @date 2019-11-30 23:21
 **/
@RestController
@RequestMapping("web/api/example")
public class WebExampleController extends BaseController {


    @GetMapping(value = "/demo")
    @ApiOperation(value = "获取用户信息")
    @ResponseBody
    public ApiResponse<String> demo() {
        return success("success");
    }
}
