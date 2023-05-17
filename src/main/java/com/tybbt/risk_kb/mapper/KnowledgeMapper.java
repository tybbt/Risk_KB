package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.Knowledge;
import com.tybbt.risk_kb.domain.KnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeMapper {
    long countByExample(KnowledgeExample example);

    int deleteByExample(KnowledgeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    List<Knowledge> selectByExample(KnowledgeExample example);

    Knowledge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
}