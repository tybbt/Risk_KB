package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.domain.KnowledgeManagementExample;
import com.tybbt.risk_kb.mapper.KnowledgeManagementMapper;
import com.tybbt.risk_kb.req.KnowledgeManagementQueryReq;
import com.tybbt.risk_kb.req.KnowledgeManagementSaveReq;
import com.tybbt.risk_kb.resp.KnowledgeManagementListResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KnowledgeManagementService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private SnowFlake snowFlake;
    @Resource
    private KnowledgeManagementMapper knowledgeManagementMapper;

    public PageResp<KnowledgeManagementListResp> list(KnowledgeManagementQueryReq req) {
        KnowledgeManagementExample knowledgeManagementExample = new KnowledgeManagementExample();
        KnowledgeManagementExample.Criteria criteria = knowledgeManagementExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        // 调用CategoryMapper的list方法
        List<KnowledgeManagement> knowledgeManagementList = knowledgeManagementMapper.selectByExample(knowledgeManagementExample);

        PageInfo<KnowledgeManagement> pageInfo = new PageInfo<>(knowledgeManagementList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());

        // 列表复制
        List<KnowledgeManagementListResp> list = CopyUtil.copyList(knowledgeManagementList, KnowledgeManagementListResp.class);

        PageResp<KnowledgeManagementListResp> pageResp = new PageResp<>();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public List<KnowledgeManagement> search(String name) {
        KnowledgeManagementExample knowledgeManagementExample = new KnowledgeManagementExample();
        KnowledgeManagementExample.Criteria crietria = knowledgeManagementExample.createCriteria();
        crietria.andNameLike(name);
        return knowledgeManagementMapper.selectByExample(knowledgeManagementExample);
    }
    public void save(KnowledgeManagementSaveReq req) {
        KnowledgeManagement knowledgeManagement = CopyUtil.copy(req, KnowledgeManagement.class);
        if (ObjectUtils.isEmpty(knowledgeManagement.getId())) {
            // 自增，uuid，雪花
            knowledgeManagement.setId(snowFlake.nextId());
            if (ObjectUtils.isEmpty(knowledgeManagement.getState())) {
                knowledgeManagement.setState(2);
            }
            if (ObjectUtils.isEmpty(knowledgeManagement.getNumber())) {
                knowledgeManagement.setNumber(0);
            }
            if (ObjectUtils.isEmpty(knowledgeManagement.getUseratio())) {
                knowledgeManagement.setUseratio((float)0.0);
            }
            knowledgeManagementMapper.insert(knowledgeManagement);
        } else {
            knowledgeManagementMapper.updateByPrimaryKey(knowledgeManagement);
        }
    }

    public void delete(Long id) {
        knowledgeManagementMapper.deleteByPrimaryKey(id);
    }
}
