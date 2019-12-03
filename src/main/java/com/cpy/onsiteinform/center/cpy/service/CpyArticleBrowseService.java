package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleBrowseDO;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyArticleBrowseService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyArticleBrowseDO queryObject(Integer articleId);

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyArticleBrowseDO CpyArticleBrowse) throws Exception;
}
