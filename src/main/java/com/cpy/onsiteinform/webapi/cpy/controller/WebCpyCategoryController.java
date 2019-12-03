package com.cpy.onsiteinform.webapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.service.CpyCategoryService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyCategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("分类")
@RestController
@RequestMapping("web/api/cpycategory")
public class WebCpyCategoryController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(WebCpyCategoryController.class);
    @Autowired

    @Resource
    private CpyCategoryService cpyCategoryService;


    /**
     * 所有列表
     */
    @ApiOperation("文章分类所有列表")
    @RequestMapping(value = "/articleAllList", method = RequestMethod.POST)
    public ApiResponse<List<CpyCategoryVO>> articleAllList() {
        return success(cpyCategoryService.categoryList(0));
    }

    /**
     * 所有列表
     */
    @ApiOperation("项目所有列表")
    @RequestMapping(value = "/projectAllList", method = RequestMethod.POST)
    public ApiResponse<List<CpyCategoryVO>> projectAllList() {
        return success(cpyCategoryService.categoryList(1));
    }


}
