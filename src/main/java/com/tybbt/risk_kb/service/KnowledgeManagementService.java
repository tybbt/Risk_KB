package com.tybbt.risk_kb.service;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.domain.KnowledgeManagementExample;
import com.tybbt.risk_kb.mapper.KnowledgeManagementMapper;
import com.tybbt.risk_kb.req.KnowledgeManagementSaveReq;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KnowledgeManagementService {
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private KnowledgeManagementMapper knowledgeManagementMapper;

    public List<KnowledgeManagement> list() {
        return knowledgeManagementMapper.selectByExample(null);
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
            knowledgeManagementMapper.insert(knowledgeManagement);
        } else {
            knowledgeManagementMapper.updateByPrimaryKey(knowledgeManagement);
        }
    }

    public void delete(Long id) {
        knowledgeManagementMapper.deleteByPrimaryKey(id);
    }
}
