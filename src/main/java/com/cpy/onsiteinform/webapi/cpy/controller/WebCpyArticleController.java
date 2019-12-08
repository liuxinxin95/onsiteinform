package com.cpy.onsiteinform.webapi.cpy.controller;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleBrowseDO;
import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleBrowseService;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleService;
import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyArticleVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
@Api("文章")
@RestController
@RequestMapping("web/api/cpyarticle")
public class WebCpyArticleController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(WebCpyArticleController.class);


    @Autowired
    private CpyArticleService cpyArticleService;

    @Resource
    private CpyArticleBrowseService cpyArticleBrowseService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponse<PageInfo<CpyArticleVO>> list(@RequestBody QueryArticleParam param) {
        //查询列表数据
        return success(cpyArticleService.queryList(param));
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/articleDetail/{id}", method = RequestMethod.GET)
    public ApiResponse<CpyArticleVO> articleDetail(@PathVariable("id") Integer id) {
        CpyArticleDO cpyArticle = cpyArticleService.queryObject(id);
        CpyArticleBrowseDO cpyArticleBrowse = cpyArticleBrowseService.queryObject(cpyArticle.getId());
        cpyArticleBrowse.setBrowseNum(cpyArticleBrowse.getBrowseNum() + 1);
        try {
            cpyArticleBrowseService.update(cpyArticleBrowse);
        } catch (Exception e) {
            log.info("浏览量记录失败");
        }
        CpyArticleVO cpyArticleVO = BeanMapUtil.convertObject(cpyArticle, CpyArticleVO.class);
        cpyArticleVO.setCategoryIdList(Arrays.asList(cpyArticle.getCategoryIds().split(",")));
        cpyArticleVO.setTagList(Arrays.asList(cpyArticle.getTags().split(",")));
        cpyArticleVO.setPicList(Arrays.asList(cpyArticle.getPics().split(",")));
        return success(cpyArticleVO);
    }


}
