package com.cpy.onsiteinform.center.cpy.service.impl;

import com.cpy.onsiteinform.center.cpy.entity.CpyProjectBrowseDO;
import com.cpy.onsiteinform.center.cpy.entity.CpyProjectDO;
import com.cpy.onsiteinform.center.cpy.mapper.CpyProjectDOMapper;
import com.cpy.onsiteinform.center.cpy.service.CpyProjectBrowseService;
import com.cpy.onsiteinform.center.cpy.service.CpyProjectService;
import com.cpy.onsiteinform.mngapi.cpy.param.QueryProjectParam;
import com.cpy.onsiteinform.mngapi.cpy.vo.CpyProjectVO;
import com.cpy.onsiteinform.util.BeanMapUtil;
import com.cpy.onsiteinform.util.PinyinUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Primary
public class CpyProjectServiceImpl implements CpyProjectService {
    @Autowired
    private CpyProjectDOMapper cpyProjectDao;

    @Value("${project.package.path}")
    private String url;


    @Resource
    private CpyProjectBrowseService cpyProjectBrowseService;

    @Override
    public CpyProjectDO queryObject(Integer id) {
        return cpyProjectDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<CpyProjectVO> queryList(QueryProjectParam param) {

        PageInfo<CpyProjectDO> pageInfo = PageHelper.startPage(param.getPageNum(),
                param.getPageSize()).doSelectPageInfo(() -> cpyProjectDao.queryListByParam(param));

        List<CpyProjectVO> list = pageInfo.getList().stream().map(x -> {
            CpyProjectVO cpyProjectVO = BeanMapUtil.convertObject(x, CpyProjectVO.class);
            cpyProjectVO.setCategoryIdList(Arrays.asList(x.getCategoryIds(), ","));
            cpyProjectVO.setPicList(Arrays.asList(x.getPics(), ","));
            CpyProjectBrowseDO cpyProjectBrowse = cpyProjectBrowseService.queryObject(x.getId());
            if (cpyProjectBrowse != null) {
                cpyProjectVO.setBrowseNum(cpyProjectBrowse.getBrowseNum());
            } else {
                cpyProjectVO.setBrowseNum(0);
            }
            return cpyProjectVO;
        }).collect(Collectors.toList());
        PageInfo<CpyProjectVO> voPageInfo = BeanMapUtil.convertObject(pageInfo, PageInfo.class);
        voPageInfo.setList(list);
        return voPageInfo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CpyProjectDO CpyProject) throws Exception {
        CpyProject.setCreateTime(new Date());
        CpyProject.setUpdateTime(new Date());
        cpyProjectDao.insert(CpyProject);
        String pingYin = PinyinUtils.getPingYin(CpyProject.getTitle());
        File dir = new File(url + pingYin + "/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CpyProjectDO CpyProject) throws Exception {
        cpyProjectDao.updateByPrimaryKeySelective(CpyProject);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        cpyProjectDao.deleteByPrimaryKey(id);
    }

    /**
     * 页面访问
     *
     * @param id
     * @return
     */
    @Override
    public CpyProjectVO projectDetail(Integer id) {
        CpyProjectDO cpyProject = cpyProjectDao.selectByPrimaryKey(id);
        CpyProjectBrowseDO cpyProjectBrowse = cpyProjectBrowseService.queryObject(cpyProject.getId());
        if (cpyProjectBrowse != null) {
            cpyProjectBrowse.setBrowseNum(cpyProjectBrowse.getBrowseNum() + 1);
            cpyProjectBrowseService.update(cpyProjectBrowse);
        } else {
            cpyProjectBrowse = new CpyProjectBrowseDO();
            cpyProjectBrowse.setBrowseNum(1);
            cpyProjectBrowse.setProjectId(id);
            cpyProjectBrowse.setCreateTime(new Date());
            cpyProjectBrowse.setUpdateTime(new Date());
            cpyProjectBrowseService.save(cpyProjectBrowse);
        }
        CpyProjectVO cpyProjectVO = BeanMapUtil.convertObject(cpyProject, CpyProjectVO.class);
        cpyProjectVO.setCategoryIdList(Arrays.asList(cpyProject.getCategoryIds().split(",")));
        cpyProjectVO.setPicList(Arrays.asList(cpyProject.getPics().split(",")));
        return cpyProjectVO;
    }
}
