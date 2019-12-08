package com.cpy.onsiteinform.mngapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleBrowseService;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyArticleVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("文章")
@RestController
@RequestMapping("mng/api/cpyarticle")
public class CpyArticleController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(CpyArticleController.class);


    @Autowired
    private CpyArticleService cpyArticleService;

    @Resource
    private CpyArticleBrowseService cpyArticleBrowseService;

    /**
     * 列表
     */
    @ApiOperation("列表(后台)")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponse<PageInfo<CpyArticleVO>> list(@RequestBody QueryArticleParam param) {
        return success(cpyArticleService.queryList(param));
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyArticleVO> info(@PathVariable("id") Integer id) {
        CpyArticleDO cpyArticle = cpyArticleService.queryObject(id);
        CpyArticleVO cpyArticleVO = BeanMapUtil.convertObject(cpyArticle, CpyArticleVO.class);
        cpyArticleVO.setCategoryIdList(Arrays.asList(cpyArticle.getCategoryIds().split(",")));
        cpyArticleVO.setTagList(Arrays.asList(cpyArticle.getTags().split(",")));
        cpyArticleVO.setPicList(Arrays.asList(cpyArticle.getPics().split(",")));
        return success(cpyArticleVO);
    }


    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody CpyArticleVO cpyArticle) {
        try {
            CpyArticleDO cpyArticle1 = BeanMapUtil.convertObject(cpyArticle, CpyArticleDO.class);
            cpyArticle1.setCategoryIds(String.join(",", cpyArticle.getCategoryIdList()));
            cpyArticle1.setTags(String.join(",", cpyArticle.getTagList()));
            cpyArticle1.setPics(String.join(",", cpyArticle.getPicList()));
            cpyArticleService.save(cpyArticle1);
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
    public ApiResponse<Boolean> update(@RequestBody CpyArticleVO cpyArticle) {
        try {
            CpyArticleDO cpyArticle1 = BeanMapUtil.convertObject(cpyArticle, CpyArticleDO.class);
            cpyArticle1.setCategoryIds(String.join(",", cpyArticle.getCategoryIdList()));
            cpyArticle1.setTags(String.join(",", cpyArticle.getTagList()));
            cpyArticle1.setPics(String.join(",", cpyArticle.getPicList()));
            cpyArticleService.update(cpyArticle1);
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
            cpyArticleService.delete(id);
        } catch (Exception e) {
            log.error("删除异常", e);
            return success(false);
        }
        return success(true);
    }

}
