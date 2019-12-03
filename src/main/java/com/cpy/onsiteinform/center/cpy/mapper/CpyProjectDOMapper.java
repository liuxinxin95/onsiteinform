package com.cpy.onsiteinform.center.cpy.mapper;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectDO;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryProjectParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CpyProjectDOMapper extends Mapper<CpyProjectDO> {

    List<CpyProjectDO> queryListByParam(QueryProjectParam param);
}