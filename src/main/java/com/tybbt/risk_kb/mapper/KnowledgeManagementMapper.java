package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.domain.KnowledgeManagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeManagementMapper {
    long countByExample(KnowledgeManagementExample example);

    int deleteByExample(KnowledgeManagementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KnowledgeManagement record);

    int insertSelective(KnowledgeManagement record);

    List<KnowledgeManagement> selectByExample(KnowledgeManagementExample example);

    KnowledgeManagement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") KnowledgeManagement record, @Param("example") KnowledgeManagementExample example);

    int updateByExample(@Param("record") KnowledgeManagement record, @Param("example") KnowledgeManagementExample example);

    int updateByPrimaryKeySelective(KnowledgeManagement record);

    int updateByPrimaryKey(KnowledgeManagement record);
}