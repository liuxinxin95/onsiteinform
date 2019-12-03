package com.cpy.onsiteinform.center.cpy.service;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectDO;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryProjectParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyProjectVO;
import com.github.pagehelper.PageInfo;


/**
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2019-11-13
 */
public interface CpyProjectService {
    /**
     * 根据ID查询
     *
     * @return
     */
    CpyProjectDO queryObject(Integer id);

    /**
     * 查询列表
     *
     * @param map
     * @return
     */
    PageInfo<CpyProjectVO> queryList(QueryProjectParam param);

    /**
     * 保存
     *
     * @throws Exception
     */
    void save(CpyProjectDO CpyProject) throws Exception;

    /**
     * 更新
     *
     * @throws Exception
     */
    void update(CpyProjectDO CpyProject) throws Exception;

    /**
     * 删除
     *
     * @throws Exception
     */
    void delete(Integer id) throws Exception;

    /**
     * 页面访问
     *
     * @param id
     * @return
     */
    CpyProjectVO projectDetail(Integer id);
}
