package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleBrowseDO;
import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyArticleDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleBrowseService;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleService;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyArticleVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Primary
public class CpyArticleServiceImpl implements CpyArticleService {

    @Resource
    private CpyArticleDOMapper cpyArticleDao;

    @Resource
    private CpyArticleBrowseService cpyArticleBrowseService;

    @Override
    public CpyArticleDO queryObject(Integer id) {
        return cpyArticleDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<CpyArticleVO> queryList(QueryArticleParam param) {
        PageInfo<CpyArticleDO> pageInfo = PageHelper.startPage(param.getPageNum(),
                param.getPageSize()).doSelectPageInfo(() -> cpyArticleDao.queryListByParam(param));
        PageInfo<CpyArticleVO> voPageInfo = BeanMapUtil.convertObject(pageInfo, PageInfo.class);
        List<CpyArticleVO> articleVOS = pageInfo.getList().stream().map(x -> {
            CpyArticleVO cpyArticleVO = BeanMapUtil.convertObject(x, CpyArticleVO.class);
            cpyArticleVO.setCategoryIdList(Arrays.asList(x.getCategoryIds(), ","));
            cpyArticleVO.setPicList(Arrays.asList(x.getPics(), ","));
            cpyArticleVO.setTagList(Arrays.asList(x.getTags(), ","));
            CpyArticleBrowseDO cpyArticleBrowse = cpyArticleBrowseService.queryObject(x.getId());
            if (cpyArticleBrowse != null) {
                cpyArticleVO.setBrowseNum(cpyArticleBrowse.getBrowseNum());
            } else {
                cpyArticleVO.setBrowseNum(0);
            }
            return cpyArticleVO;
        }).collect(Collectors.toList());
        voPageInfo.setList(articleVOS);
        return voPageInfo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CpyArticleDO CpyArticle) throws Exception {
        CpyArticle.setCreateTime(new Date());
        CpyArticle.setUpdateTime(new Date());
        cpyArticleDao.insert(CpyArticle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyArticleDO CpyArticle) throws Exception {
        cpyArticleDao.updateByPrimaryKeySelective(CpyArticle);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        cpyArticleDao.deleteByPrimaryKey(id);
    }


}
