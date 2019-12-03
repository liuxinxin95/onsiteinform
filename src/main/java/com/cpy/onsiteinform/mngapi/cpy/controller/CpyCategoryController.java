package com.cpy.onsiteinform.mngapi.cpy.controller;

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
@RequestMapping("mng/api/cpycategory")
public class CpyCategoryController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(CpyCategoryController.class);
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

    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyCategoryVO> info(@PathVariable("id") Integer id) {
        return success(cpyCategoryService.queryObject(id));
    }

    /**
     * 保存
     */
    @ApiOperation("文章分类保存")
    @RequestMapping(value = "/articleSave", method = RequestMethod.POST)
    public ApiResponse<Boolean> articleSave(@RequestBody CpyCategoryVO cpyCategory) {
        try {
            cpyCategoryService.save(cpyCategory, 0);
        } catch (Exception e) {
            log.error("保存异常", e);
            return success(false);
        }
        return success(true);
    }

    /**
     * 保存
     */
    @ApiOperation("项目分类保存")
    @RequestMapping(value = "/projectSave", method = RequestMethod.POST)
    public ApiResponse<Boolean> projectSave(@RequestBody CpyCategoryVO cpyCategory) {
        try {
            cpyCategoryService.save(cpyCategory, 1);
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
    public ApiResponse<Boolean> update(@RequestBody CpyCategoryVO cpyCategory) {
        try {
            cpyCategoryService.update(cpyCategory);
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
            cpyCategoryService.delete(id);
        } catch (Exception e) {
            log.error("修改异常", e);
            return success(false);
        }
        return success(true);
    }

}
