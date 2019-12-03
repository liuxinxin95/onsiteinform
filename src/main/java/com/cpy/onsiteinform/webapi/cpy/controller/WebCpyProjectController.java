package com.cpy.onsiteinform.webapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.service.CpyProjectService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryProjectParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyProjectVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("项目")
@RestController
@RequestMapping("web/api/cpyproject")
public class WebCpyProjectController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(WebCpyProjectController.class);


    @Autowired
    private CpyProjectService cpyProjectService;


    /**
     * 列表
     */
    @ApiOperation("列表(后台)")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponse<PageInfo<CpyProjectVO>> list(@RequestBody QueryProjectParam param) {
        return success(cpyProjectService.queryList(param));
    }


    /**
     * 信息
     */
    @ApiOperation("信息(企业站页面查询)")
    @RequestMapping(value = "/projectDetail/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyProjectVO> projectDetail(@PathVariable("id") Integer id) {
        return success(cpyProjectService.projectDetail(id));
    }


}
