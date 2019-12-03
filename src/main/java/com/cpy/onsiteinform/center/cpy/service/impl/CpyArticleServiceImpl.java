package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyArticleDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleService;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Primary
public class CpyArticleServiceImpl implements CpyArticleService {

    @Resource
    private CpyArticleDOMapper cpyArticleDao;

    @Override
    public CpyArticleDO queryObject(Integer id) {
        return cpyArticleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<CpyArticleDO> queryList(QueryArticleParam param) {
        return cpyArticleDao.queryListByParam(param);
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
