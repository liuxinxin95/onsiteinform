package com.cpy.onsiteinform.center.mng.service;

import com.cpy.onsiteinform.mngapi.onsite.param.QueryContentInfoParam;
import com.cpy.onsiteinform.mngapi.onsite.vo.MngContentInfoVO;
import com.github.pagehelper.PageInfo;

/**
 * @author Carl
 * @ClassName MngContentInfoService
 * @Description
 * @date 2019-12-08 11:12
 **/
public interface MngContentInfoService {


    /**
     * 添加
     *
     * @param infoVO
     */
    void save(MngContentInfoVO infoVO);

    /**
     * 列表查询
     *
     * @param param
     */
    PageInfo<MngContentInfoVO> getPage(QueryContentInfoParam param);
}
