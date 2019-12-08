package com.cpy.onsiteinform.center.mng.service;

import com.cpy.onsiteinform.mngapi.cpy.vo.MngCategoryInfoVO;

import java.util.List;

/**
 * @author Carl
 * @ClassName MngCategoryInfoService
 * @Description
 * @date 2019-12-08 09:31
 **/
public interface MngCategoryInfoService {

    /**
     * 获取一级分类
     *
     * @return
     */
    List<MngCategoryInfoVO> getParentCategory();


    /**
     * 根据夫级id获取下级分类列表
     *
     * @return
     */
    List<MngCategoryInfoVO> getByParent(Integer parentId);

    /**
     * 获取树状分类树
     *
     * @return
     */
    List<MngCategoryInfoVO> getCategoryTree();
}
