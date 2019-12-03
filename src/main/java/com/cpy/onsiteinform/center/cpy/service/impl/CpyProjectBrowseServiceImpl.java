package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectBrowseDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyProjectBrowseDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyProjectBrowseService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Primary
public class CpyProjectBrowseServiceImpl implements CpyProjectBrowseService {

    @Resource
    private CpyProjectBrowseDOMapper cpyProjectBrowseDao;

    @Override
    public CpyProjectBrowseDO queryObject(Integer projectId) {
        return cpyProjectBrowseDao.selectByPrimaryKey(projectId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CpyProjectBrowseDO CpyProjectBrowse) {
        cpyProjectBrowseDao.insert(CpyProjectBrowse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyProjectBrowseDO CpyProjectBrowse) {
        cpyProjectBrowseDao.updateByPrimaryKeySelective(CpyProjectBrowse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer projectId) throws Exception {
        cpyProjectBrowseDao.deleteByPrimaryKey(projectId);
    }


}
