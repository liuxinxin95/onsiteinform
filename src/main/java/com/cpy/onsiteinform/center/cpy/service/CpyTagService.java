package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.center.cpy.entity.CpyTagDO;

import java.util.List;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyTagService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyTagDO queryObject(Integer id);

    /**
     * 查询列表
     *
     * @param map
     * @return
     */
    List<CpyTagDO> queryAll();

    /**
     * 保存
     *
     * @throws Exception
     */
    void save(CpyTagDO CpyTag) throws Exception;

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyTagDO CpyTag) throws Exception;

    /**
     * 删除
     *
     * @throws Exception
     */
    void delete(Integer id) throws Exception;


}
