package com.cpy.onsiteinform.center.mng.mapper;

import com.cpy.onsiteinform.center.mng.entity.MngContentInfoDO;
import com.cpy.onsiteinform.mngapi.onsite.param.QueryContentInfoParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MngContentInfoDOMapper extends Mapper<MngContentInfoDO> {

    /**
     * 查询
     * @param param
     * @return
     */
    List<MngContentInfoDO> selectByParam(QueryContentInfoParam param);
}