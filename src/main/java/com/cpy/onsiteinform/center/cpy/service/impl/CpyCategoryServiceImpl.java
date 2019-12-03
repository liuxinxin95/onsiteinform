package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyCategoryDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyCategoryDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyCategoryService;
import com.cpy.onsiteinform.exception.RRException;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyCategoryVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Primary
public class CpyCategoryServiceImpl implements CpyCategoryService {

    @Resource
    private CpyCategoryDOMapper cpyCategoryDao;

    @Override
    public CpyCategoryVO queryObject(Integer id) {
        return BeanMapUtil.convertObject(cpyCategoryDao.selectByPrimaryKey(id), CpyCategoryVO.class);
    }


    /**
     * @param cpyCategory
     * @param type        0文章分类，1项目分类
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CpyCategoryVO cpyCategory, Integer type) throws Exception {
        CpyCategoryDO categoryDO = BeanMapUtil.convertObject(cpyCategory, CpyCategoryDO.class);
        categoryDO.setType(type);
        categoryDO.setCreateTime(new Date());
        categoryDO.setUpdateTime(new Date());
        cpyCategoryDao.insert(categoryDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyCategoryVO cpyCategory) throws Exception {
        CpyCategoryDO cpyCategoryDO = cpyCategoryDao.selectByPrimaryKey(cpyCategory.getId());
        if (cpyCategoryDO == null) {
            throw new RRException("查询失败请重试");
        }
        CpyCategoryDO categoryDO = BeanMapUtil.convertObject(cpyCategory, CpyCategoryDO.class);
        categoryDO.setUpdateTime(new Date());
        cpyCategoryDao.updateByPrimaryKeySelective(categoryDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        cpyCategoryDao.deleteByPrimaryKey(id);
    }


    /**
     * 发分类列表 0文章分类，1项目分类
     *
     * @param type
     * @return
     */
    @Override
    public List<CpyCategoryVO> categoryList(Integer type) {
        CpyCategoryDO cpyCategoryDO = new CpyCategoryDO();
        cpyCategoryDO.setType(type);
        List<CpyCategoryDO> cpyTags = cpyCategoryDao.select(cpyCategoryDO);
        return BeanMapUtil.convertList(cpyTags, CpyCategoryVO.class);
    }

}
