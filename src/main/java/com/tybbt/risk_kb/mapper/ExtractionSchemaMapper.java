package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.ExtractionSchema;
import com.tybbt.risk_kb.domain.ExtractionSchemaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtractionSchemaMapper {
    long countByExample(ExtractionSchemaExample example);

    int deleteByExample(ExtractionSchemaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExtractionSchema record);

    int insertSelective(ExtractionSchema record);

    List<ExtractionSchema> selectByExample(ExtractionSchemaExample example);

    ExtractionSchema selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExtractionSchema record, @Param("example") ExtractionSchemaExample example);

    int updateByExample(@Param("record") ExtractionSchema record, @Param("example") ExtractionSchemaExample example);

    int updateByPrimaryKeySelective(ExtractionSchema record);

    int updateByPrimaryKey(ExtractionSchema record);
}