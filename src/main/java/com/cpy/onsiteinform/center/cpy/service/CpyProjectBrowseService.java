package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectBrowseDO;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyProjectBrowseService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyProjectBrowseDO queryObject(Integer projectId);


    /**
     * 保存
     *
     * @throws Exception
     */
    void save(CpyProjectBrowseDO CpyProjectBrowse);

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyProjectBrowseDO CpyProjectBrowse);

    /**
     * 删除
     *
     * @throws Exception
     */
    void delete(Integer projectId) throws Exception;

}
