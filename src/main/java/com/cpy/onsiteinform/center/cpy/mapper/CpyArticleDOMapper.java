package com.cpy.onsiteinform.center.cpy.mapper;

import com.cpy.onsiteinform.center.cpy.entity.CpyArticleDO;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryArticleParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CpyArticleDOMapper extends Mapper<CpyArticleDO> {

    List<CpyArticleDO> queryListByParam(QueryArticleParam param);
}