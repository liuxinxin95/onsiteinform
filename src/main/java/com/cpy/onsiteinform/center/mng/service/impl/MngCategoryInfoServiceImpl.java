package com.cpy.onsiteinform.center.mng.service.impl;

import com.cpy.onsiteinform.center.mng.entity.MngCategoryInfoDO;
import com.cpy.onsiteinform.center.mng.mapper.MngCategoryInfoDOMapper;
import com.cpy.onsiteinform.center.mng.service.MngCategoryInfoService;
import com.cpy.onsiteinform.common.SysUser;
import com.cpy.onsiteinform.common.UserContext;
import com.cpy.onsiteinform.exception.RRException;
import com.cpy.onsiteinform.mngapi.onsite.vo.MngCategoryInfoVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.cpy.onsiteinform.util.TreeUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
     *
     * @return
     */
    @Override
    public List<MngCategoryInfoVO> getByParent(Integer parentId) {
        MngCategoryInfoDO categoryInfoDO = new MngCategoryInfoDO();
        categoryInfoDO.setValid(true);
        categoryInfoDO.setParentId(parentId);
        List<MngCategoryInfoDO> categoryInfoDOS = mngCategoryInfoDOMapper.select(categoryInfoDO);
        return BeanMapUtil.convertList(categoryInfoDOS, MngCategoryInfoVO.class);
    }

    /**
     * 获取树状分类树
     *
     * @return
     */
    @Override
    public List<MngCategoryInfoVO> getCategoryTree() {
        MngCategoryInfoDO categoryInfoDO = new MngCategoryInfoDO();
        categoryInfoDO.setValid(true);
        List<MngCategoryInfoDO> categoryInfoDOS = mngCategoryInfoDOMapper.select(categoryInfoDO);
        List<MngCategoryInfoVO> mngCategoryInfoVOS = BeanMapUtil.convertList(categoryInfoDOS, MngCategoryInfoVO.class);
        return TreeUtil.bulid(mngCategoryInfoVOS, 0);
    }

    /**
     * 添加
     *
     * @param infoVO
     */
    @Override
    public void saveCategory(MngCategoryInfoVO infoVO) {
        if (infoVO.getParentId() == null) {
            throw new RRException("请选择父级类目");
        }
        MngCategoryInfoDO categoryInfoDO = BeanMapUtil.convertObject(infoVO, MngCategoryInfoDO.class);
        categoryInfoDO.setValid(true);
        categoryInfoDO.setUpdateTime(new Date());
        categoryInfoDO.setCreateTime(new Date());
        categoryInfoDO.setCreateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        categoryInfoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngCategoryInfoDOMapper.insert(categoryInfoDO);
    }

    /**
     * 修改
     *
     * @param infoVO
     */
    @Override
    public void updateCategory(MngCategoryInfoVO infoVO) {
        MngCategoryInfoDO categoryInfoDO = mngCategoryInfoDOMapper.selectByPrimaryKey(infoVO.getId());
        if (categoryInfoDO == null) {
            throw new RRException("分类查询失败，请重试");
        }
        categoryInfoDO.setName(infoVO.getName());
        categoryInfoDO.setParentId(infoVO.getParentId());
        categoryInfoDO.setUpdateTime(new Date());
        categoryInfoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngCategoryInfoDOMapper.updateByPrimaryKeySelective(categoryInfoDO);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteCategory(Integer id) {
        MngCategoryInfoDO categoryInfoDO = mngCategoryInfoDOMapper.selectByPrimaryKey(id);
        if (categoryInfoDO == null) {
            throw new RRException("分类查询失败，请重试");
        }
        categoryInfoDO.setValid(false);
        mngCategoryInfoDOMapper.updateByPrimaryKeySelective(categoryInfoDO);
    }

}
