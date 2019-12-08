package com.cpy.onsiteinform.center.mng.service.impl;

import com.cpy.onsiteinform.center.mng.entity.MngContentInfoDO;
import com.cpy.onsiteinform.center.mng.mapper.MngContentInfoDOMapper;
import com.cpy.onsiteinform.center.mng.service.MngContentInfoService;
import com.cpy.onsiteinform.common.SysUser;
import com.cpy.onsiteinform.common.UserContext;
import com.cpy.onsiteinform.exception.RRException;
import com.cpy.onsiteinform.mngapi.onsite.param.QueryContentInfoParam;
import com.cpy.onsiteinform.mngapi.onsite.vo.MngContentInfoVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Carl
 * @ClassName MngContentInfoServiceImpl
 * @Description
 * @date 2019-12-08 11:12
 **/
public class MngContentInfoServiceImpl implements MngContentInfoService {

    @Resource
    private MngContentInfoDOMapper mngContentInfoDOMapper;

    /**
     * 添加
     *
     * @param infoVO
     */
    @Override
    public void save(MngContentInfoVO infoVO) {
        MngContentInfoDO mngContentInfoDO = BeanMapUtil.convertObject(infoVO, MngContentInfoDO.class);
        if (CollectionUtils.isNotEmpty(infoVO.getTagList())) {
            mngContentInfoDO.setTags(String.join(",", infoVO.getTagList()));
        }
        mngContentInfoDO.setCreateTime(new Date());
        mngContentInfoDO.setUpdateTime(new Date());
        mngContentInfoDO.setStatus(0);
        mngContentInfoDO.setCreateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngContentInfoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngContentInfoDOMapper.insert(mngContentInfoDO);
    }

    /**
     * 修改
     *
     * @param infoVO
     */
    @Override
    public void update(MngContentInfoVO infoVO) {
        MngContentInfoDO infoDO = mngContentInfoDOMapper.selectByPrimaryKey(infoVO.getId());
        if (infoDO == null) {
            throw new RRException("查询失败请重试");
        }
        MngContentInfoDO mngContentInfoDO = BeanMapUtil.convertObject(infoVO, MngContentInfoDO.class);
        if (CollectionUtils.isNotEmpty(infoVO.getTagList())) {
            mngContentInfoDO.setTags(String.join(",", infoVO.getTagList()));
        }
        mngContentInfoDO.setUpdateTime(new Date());
        mngContentInfoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngContentInfoDOMapper.updateByPrimaryKeySelective(mngContentInfoDO);
    }

    /**
     * 列表查询
     *
     * @param param
     */
    @Override
    public PageInfo<MngContentInfoVO> getPage(QueryContentInfoParam param) {
        PageInfo<MngContentInfoDO> pageInfo = PageHelper.startPage(param.getPageNum(),
                param.getPageSize()).doSelectPageInfo(() -> mngContentInfoDOMapper.selectByParam(param));
        if (CollectionUtils.isEmpty(pageInfo.getList())) {
            return new PageInfo<>();
        }
        List<MngContentInfoVO> infoVOS = pageInfo.getList().stream().map(x -> {
            MngContentInfoVO mngContentInfoVO = BeanMapUtil.convertObject(x, MngContentInfoVO.class);
            mngContentInfoVO.setTagList(Arrays.asList(x.getTags(), ","));
            return mngContentInfoVO;
        }).collect(Collectors.toList());
        PageInfo<MngContentInfoVO> voPageInfo = BeanMapUtil.convertObject(pageInfo, PageInfo.class);
        voPageInfo.setList(infoVOS);
        return voPageInfo;
    }

    /**
     * 审核发布
     *
     * @param id
     */
    @Override
    public void audit(Integer id) {
        MngContentInfoDO infoDO = mngContentInfoDOMapper.selectByPrimaryKey(id);
        if (infoDO == null) {
            throw new RRException("查询失败请重试");
        }
        infoDO.setStatus(1);
        infoDO.setUpdateTime(new Date());
        infoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngContentInfoDOMapper.updateByPrimaryKeySelective(infoDO);
    }


    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        MngContentInfoDO infoDO = mngContentInfoDOMapper.selectByPrimaryKey(id);
        if (infoDO == null) {
            throw new RRException("查询失败请重试");
        }
        infoDO.setDisable(true);
        infoDO.setUpdateTime(new Date());
        infoDO.setUpdateUser(UserContext.<SysUser>getContext().getCurrentUser().getUserId());
        mngContentInfoDOMapper.updateByPrimaryKeySelective(infoDO);
    }

}
