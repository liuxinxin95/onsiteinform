package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyTagDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyTagDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyTagService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Primary
public class CpyTagServiceImpl implements CpyTagService {

    @Resource
    private CpyTagDOMapper cpyTagDao;

    @Override
    public CpyTagDO queryObject(Integer id) {
        return cpyTagDao.selectByPrimaryKey(id);
    }

    @Override
    public List<CpyTagDO> queryAll() {
        return cpyTagDao.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CpyTagDO CpyTag) throws Exception {
        CpyTag.setCreateTime(new Date());
        CpyTag.setUpdateTime(new Date());
        cpyTagDao.insert(CpyTag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyTagDO CpyTag) throws Exception {
        cpyTagDao.updateByPrimaryKeySelective(CpyTag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        cpyTagDao.deleteByPrimaryKey(id);
    }


}
