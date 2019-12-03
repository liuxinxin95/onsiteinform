package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleBrowseDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyArticleBrowseDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyArticleBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Primary
public class CpyArticleBrowseServiceImpl implements CpyArticleBrowseService {
    @Autowired
    private CpyArticleBrowseDOMapper cpyArticleBrowseDao;

    @Override
    public CpyArticleBrowseDO queryObject(Integer articleId) {
        return cpyArticleBrowseDao.selectByPrimaryKey(articleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyArticleBrowseDO CpyArticleBrowse) throws Exception{
        cpyArticleBrowseDao.updateByPrimaryKeySelective(CpyArticleBrowse);
    }
}
