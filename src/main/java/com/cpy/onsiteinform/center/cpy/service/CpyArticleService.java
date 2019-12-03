package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;

import java.util.List;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyArticleService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyArticleDO queryObject(Integer id);

    /**
     * 查询列表
     *
     * @param map
     * @return
     */
    List<CpyArticleDO> queryList(QueryArticleParam param);

    /**
     * 保存
     *
     * @throws Exception
     */
    void save(CpyArticleDO CpyArticle) throws Exception;

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyArticleDO CpyArticle) throws Exception;

    /**
     * 删除
     *
     * @throws Exception
     */
    void delete(Integer id) throws Exception;


}
