package com.tybbt.risk_kb.service;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.domain.KnowledgeManagementExample;
import com.tybbt.risk_kb.mapper.KnowledgeManagementMapper;
import jakarta.annotation.Resource;

import java.util.List;

public class KnowledgeManagementService {

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
}
