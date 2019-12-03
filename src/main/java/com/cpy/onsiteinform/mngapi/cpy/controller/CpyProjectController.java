package com.cpy.onsiteinform.mngapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectDO;
import com.cpy.onsiteinform.center.cpy.service.CpyProjectService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryProjectParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyProjectVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("项目")
@RestController
@RequestMapping("mng/api/cpyproject")
public class CpyProjectController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(CpyProjectController.class);


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
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyProjectVO> info(@PathVariable("id") Integer id) {
        CpyProjectDO cpyProject = cpyProjectService.queryObject(id);
        CpyProjectVO cpyProjectVO = BeanMapUtil.convertObject(cpyProject, CpyProjectVO.class);
        cpyProjectVO.setCategoryIdList(Arrays.asList(cpyProject.getCategoryIds().split(",")));
        cpyProjectVO.setPicList(Arrays.asList(cpyProject.getPics().split(",")));
        return success(cpyProjectVO);
    }


    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody CpyProjectVO cpyProject) {
        try {
            CpyProjectDO cpyProject1 = BeanMapUtil.convertObject(cpyProject, CpyProjectDO.class);
            cpyProject1.setStatus(0);
            cpyProject1.setCategoryIds(String.join(",", cpyProject.getCategoryIdList()));
            cpyProject1.setPics(String.join(",", cpyProject.getPicList()));
            cpyProjectService.save(cpyProject1);
        } catch (Exception e) {
            log.error("保存异常", e);
            return success(false);
        }
        return success(true);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ApiResponse<Boolean> update(@RequestBody CpyProjectVO cpyProject) {
        try {
            CpyProjectDO cpyProject1 = BeanMapUtil.convertObject(cpyProject, CpyProjectDO.class);
            cpyProject1.setCategoryIds(String.join(",", cpyProject.getCategoryIdList()));
            cpyProject1.setPics(String.join(",", cpyProject.getPicList()));
            cpyProjectService.update(cpyProject1);
        } catch (Exception e) {
            log.error("修改异常", e);
            return success(false);
        }
        return success(true);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ApiResponse<Boolean> delete(@PathVariable("id") Integer id) {
        try {
            cpyProjectService.delete(id);
        } catch (Exception e) {
            log.error("删除异常", e);
            return success(false);
        }
        return success(true);
    }

}
