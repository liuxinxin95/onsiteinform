package com.cpy.onsiteinform.mngapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.entity.CpyTagDO;
import com.cpy.onsiteinform.center.cpy.service.CpyTagService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyTagVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("标签")
@RestController
@RequestMapping("mng/api/cpytag")
public class CpyTagController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(CpyTagController.class);

    @Autowired
    private CpyTagService cpyTagService;


    /**
     * 所有列表
     */
    @ApiOperation("所有列表")
    @RequestMapping(value = "/allList", method = RequestMethod.POST)
    public ApiResponse<List<CpyTagVO>> list() {
        //查询列表数据
        List<CpyTagDO> cpyTags = cpyTagService.queryAll();
        return success(BeanMapUtil.convertList(cpyTags, CpyTagVO.class));
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyTagVO> info(@PathVariable("id") Integer id) {
        CpyTagDO cpyTag = cpyTagService.queryObject(id);
        return success(BeanMapUtil.convertObject(cpyTag, CpyTagVO.class));
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResponse save(@RequestBody CpyTagVO cpyTag) {
        try {
            cpyTagService.save(BeanMapUtil.convertObject(cpyTag, CpyTagDO.class));
        } catch (Exception e) {
            return success(false);
        }
        return success(true);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ApiResponse update(@RequestBody CpyTagDO cpyTag) {
        try {
            cpyTagService.update(cpyTag);
        } catch (Exception e) {
            log.error("修改异常", e);
            success(false);
        }
        return success(true);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ApiResponse delete(@PathVariable("id") Integer id) {
        try {
            cpyTagService.delete(id);
        } catch (Exception e) {
            log.error("删除异常", e);
            return success(false);
        }
        return success(true);
    }

}
