package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.mngapi.cpy.vo.CpyCategoryVO;

import java.util.List;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyCategoryService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyCategoryVO queryObject(Integer id);


    /**
     * 保存
     *
     * @throws Exception
     */
    void save(CpyCategoryVO cpyCategory, Integer type) throws Exception;

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyCategoryVO cpyCategory) throws Exception;

    /**
     * 删除
     *
     * @throws Exception
     */
    void delete(Integer id) throws Exception;

    /**
     * 发分类列表 0文章分类，1项目分类
     *
     * @param type
     * @return
     */
    List<CpyCategoryVO> categoryList(Integer type);
}
