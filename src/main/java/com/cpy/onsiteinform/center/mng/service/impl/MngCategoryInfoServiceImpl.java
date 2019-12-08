package com.cpy.onsiteinform.center.mng.service.impl;

import com.cpy.onsiteinform.center.mng.entity.MngCategoryInfoDO;
import com.cpy.onsiteinform.center.mng.mapper.MngCategoryInfoDOMapper;
import com.cpy.onsiteinform.center.mng.service.MngCategoryInfoService;
import com.cpy.onsiteinform.mngapi.cpy.vo.MngCategoryInfoVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.cpy.onsiteinform.util.TreeUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName MngCategoryInfoServiceImpl
 * @Description
 * @date 2019-12-08 09:32
 **/
@Service
@Primary
public class MngCategoryInfoServiceImpl implements MngCategoryInfoService {

    @Resource
    private MngCategoryInfoDOMapper mngCategoryInfoDOMapper;


    /**
     * 获取一级分类
     *
     * @return
     */
    @Override
    public List<MngCategoryInfoVO> getParentCategory() {
        MngCategoryInfoDO categoryInfoDO = new MngCategoryInfoDO();
        categoryInfoDO.setValid(true);
        categoryInfoDO.setParentId(0);
        List<MngCategoryInfoDO> categoryInfoDOS = mngCategoryInfoDOMapper.select(categoryInfoDO);
        return BeanMapUtil.convertList(categoryInfoDOS, MngCategoryInfoVO.class);
    }

    /**
     * 根据夫级id获取下级分类列表
     * @return
     */
    @Override
    public List<MngCategoryInfoVO> getByParent(Integer parentId){
        MngCategoryInfoDO categoryInfoDO = new MngCategoryInfoDO();
        categoryInfoDO.setValid(true);
        categoryInfoDO.setParentId(parentId);
        List<MngCategoryInfoDO> categoryInfoDOS = mngCategoryInfoDOMapper.select(categoryInfoDO);
        return BeanMapUtil.convertList(categoryInfoDOS, MngCategoryInfoVO.class);
    }

    /**
     * 获取树状分类树
     * @return
     */
    @Override
    public List<MngCategoryInfoVO> getCategoryTree(){
        MngCategoryInfoDO categoryInfoDO = new MngCategoryInfoDO();
        categoryInfoDO.setValid(true);
        List<MngCategoryInfoDO> categoryInfoDOS = mngCategoryInfoDOMapper.select(categoryInfoDO);
        List<MngCategoryInfoVO> mngCategoryInfoVOS = BeanMapUtil.convertList(categoryInfoDOS, MngCategoryInfoVO.class);
        return TreeUtil.bulid(mngCategoryInfoVOS,0);
    }
}
